package com.implement;

import com.dao.IDao;
import com.entity.Threads;
import com.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class ThreadImp implements IDao<Integer, Threads> {
    @Override
    public List<Threads> getAll() {
        Session session = HibernateUtil.getSession().openSession();
        session.beginTransaction();
        List students = session.createQuery("from Threads").list();
        session.close();
        return students;
    }

    @Override
    public boolean create(Threads newV) {
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
    public boolean update(Threads newV) {
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
            int check_delete = session.createQuery("delete Threads where id=:params").setParameter("params",id).executeUpdate();
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
    public Threads findById(Integer id) {
        Session session = HibernateUtil.getSession().openSession();
        try {
            session.beginTransaction();
            Threads studentFound = (Threads) session.createQuery("from Threads where id=:params").setParameter("params",id).uniqueResult();
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
    public Threads findByName(String nameW) {
        return null;
    }

    @Override
    public int selectCount() {
        Session ss = HibernateUtil.getSession().openSession();

        try {
            ss.beginTransaction();

            // Long: là wrapper class đại diện xử lý kiểu dữ liệu <long>
            // HQL <=> SQL: bảng >>> mapping >>> Object
            Long cnt = (Long) ss.createQuery("select COUNT(id) from Threads").uniqueResult();

            ss.close();

            return cnt.intValue();
        } catch (Exception e) {
            // TODO: handle exception
        }

        return 0;
    }

    @Override
    public List<Threads> pagination(int page, int itemOnPage) {
        Session session = HibernateUtil.getSession().openSession();

        // Bắt đầu giao dịch
        session.beginTransaction();

        page = page < 0 ? 0 : page;

        // Thực thi truy vấn: sử dụng ngôn ngữ truy vấn HQL <=> SQL
        List<Threads> lst = session.createQuery("from Threads").setFirstResult(page * itemOnPage) // Offset
                .setMaxResults(itemOnPage) // Fetch next
                .list();

        // Đóng kết nối
        session.close();

        return lst;
    }
}
