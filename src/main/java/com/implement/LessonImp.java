package com.implement;

import com.dao.IDao;
import com.entity.Lesson;
import com.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class LessonImp implements IDao<Integer, Lesson> {
    @Override
    public List<Lesson> getAll() {
        Session session = HibernateUtil.getSession().openSession();
        session.beginTransaction();
        List students = session.createQuery("from Lesson").list();
        session.close();
        return students;
    }

    @Override
    public boolean create(Lesson newV) {
        Session session = HibernateUtil.getSession().openSession();
        try {
            session.beginTransaction();
            int check = (Integer) session.save(newV);
            session.getTransaction().commit();
            session.close();
            if (check>0)
                return true;
            else
                return false;

        }catch (Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
            session.close();
            return false;
        }
    }

    @Override
    public boolean update(Lesson newV) {
        Session session = HibernateUtil.getSession().openSession();
        try{
            session.beginTransaction();
            session.update(newV);
            session.getTransaction().commit();
            session.close();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
            session.close();
            return false;
        }
    }

    @Override
    public boolean delete(Integer id) {
        Session session = HibernateUtil.getSession().openSession();
        try {
            session.beginTransaction();
            int check_delete = session.createQuery("delete Lesson where id=:params").setParameter("params",id).executeUpdate();
            session.close();
            if (check_delete>0)
                return true;
            return false;
        }catch (Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
            session.close();
            return false;
        }
    }

    @Override
    public Lesson findById(Integer id) {
        Session session = HibernateUtil.getSession().openSession();
        try {
            session.beginTransaction();
            Lesson studentFound = (Lesson) session.createQuery("from Lesson where id=:params").setParameter("params",id).uniqueResult();
            session.close();
            return studentFound;
        }catch (Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
            session.close();
            return null;
        }
    }

    @Override
    public Lesson findByName(String nameW) {
        Session session = HibernateUtil.getSession().openSession();
        try {
            session.beginTransaction();
            Lesson studentFound = (Lesson) session.createQuery("from Lesson where name=:params").setParameter("params",nameW).uniqueResult();
            session.close();
            return studentFound;
        }catch (Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
            session.close();
            return null;
        }
    }

    @Override
    public int selectCount() {
        Session ss = HibernateUtil.getSession().openSession();

        try {
            ss.beginTransaction();

            // Long: là wrapper class đại diện xử lý kiểu dữ liệu <long>
            // HQL <=> SQL: bảng >>> mapping >>> Object
            Long cnt = (Long) ss.createQuery("select COUNT(id) from Lesson").uniqueResult();

            ss.close();

            return cnt.intValue();
        } catch (Exception e) {
            // TODO: handle exception
        }

        return 0;
    }

    @Override
    public List<Lesson> pagination(int page, int itemOnPage) {
        Session session = HibernateUtil.getSession().openSession();

        // Bắt đầu giao dịch
        session.beginTransaction();

        page = page < 0 ? 0 : page;

        // Thực thi truy vấn: sử dụng ngôn ngữ truy vấn HQL <=> SQL
        List<Lesson> lst = session.createQuery("from Lesson").setFirstResult(page * itemOnPage) // Offset
                .setMaxResults(itemOnPage) // Fetch next
                .list();

        // Đóng kết nối
        session.close();

        return lst;
    }

    public List<Lesson > searchByName(String keyword){
        String keywordTranslate = "%" + keyword + "%";
        System.out.println("keywordTranslate: " + keywordTranslate);
        Session session = HibernateUtil.getSession().openSession();
        try {
            session.beginTransaction();
            List<Lesson > courseFound = session.createQuery("from Lesson where name like :params").setParameter("params",keywordTranslate).list();
            return courseFound;
        }catch (Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
            session.close();
            return null;
        }

    }
}
