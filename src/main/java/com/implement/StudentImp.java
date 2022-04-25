package com.implement;

import com.dao.IDao;
import com.entity.Students;
import com.entity.Students;
import com.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class StudentImp implements IDao<Integer, Students> {
    @Override
    public List<Students> getAll() {
        Session session = HibernateUtil.getSession().openSession();
        session.beginTransaction();
        List students = session.createQuery("from Students").list();
        session.close();
        return students;
    }

    @Override
    public boolean create(Students newV) {
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
    public boolean update(Students newV) {
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
            int check_delete = session.createQuery("delete Students where id=:params").setParameter("params",id).executeUpdate();
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
    public Students findById(Integer id) {
        Session session = HibernateUtil.getSession().openSession();
        try {
            session.beginTransaction();
            Students studentFound = (Students) session.createQuery("from Students where id=:params").setParameter("params",id).uniqueResult();
            session.close();
            return studentFound;
        }catch (Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
            session.close();
            return null;
        }
    }

    public Students findByEmail(String email) {
        Session session = HibernateUtil.getSession().openSession();
        try {
            session.beginTransaction();
            Students studentFound = (Students) session.createQuery("from Students where email=:params").setParameter("params",email).uniqueResult();
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
    public Students findByName(String nameW) {
        Session session = HibernateUtil.getSession().openSession();
        try {
            session.beginTransaction();
            Students studentFound = (Students) session.createQuery("from Students where name=:params").setParameter("params",nameW).uniqueResult();
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
            Long cnt = (Long) ss.createQuery("select COUNT(id) from Students").uniqueResult();

            ss.close();

            return cnt.intValue();
        } catch (Exception e) {
            // TODO: handle exception
        }

        return 0;
    }

    @Override
    public List<Students> pagination(int page, int itemOnPage) {
        Session session = HibernateUtil.getSession().openSession();

        // Bắt đầu giao dịch
        session.beginTransaction();

        page = page < 0 ? 0 : page;

        // Thực thi truy vấn: sử dụng ngôn ngữ truy vấn HQL <=> SQL
        List<Students> lst = session.createQuery("from Students").setFirstResult(page * itemOnPage) // Offset
                .setMaxResults(itemOnPage) // Fetch next
                .list();

        // Đóng kết nối
        session.close();

        return lst;
    }

    public List<Students > searchByName(String keyword){
        String keywordTranslate = "%" + keyword + "%";
        System.out.println("keywordTranslate: " + keywordTranslate);
        Session session = HibernateUtil.getSession().openSession();
        try {
            session.beginTransaction();
            List<Students > courseFound = session.createQuery("from Students where name like :params").setParameter("params",keywordTranslate).list();
            return courseFound;
        }catch (Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
            session.close();
            return null;
        }

    }
}
