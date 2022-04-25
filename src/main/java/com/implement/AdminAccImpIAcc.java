package com.implement;

import com.dao.IAccount;
import com.entity.Admin;
import com.util.HibernateUtil;
import org.hibernate.Session;

import javax.servlet.http.HttpSession;
import java.util.List;

public class AdminAccImpIAcc implements IAccount<Integer, Admin> {
    @Override
    public List<Admin> getAllAcc() {
        Session session = HibernateUtil.getSession().openSession();
        try{
            session.beginTransaction();
            List<Admin> adminList = session.createQuery("from Admin").list();
            session.close();
            return adminList;
        }catch (Exception e){
            e.printStackTrace();
            session.close();
            session.getTransaction().rollback();
            return null;
        }
    }

    @Override
    public Admin findByEmail(String email) {
        Session session = HibernateUtil.getSession().openSession();
        try{
            session.beginTransaction();
            Admin adminFound = (Admin) session.createQuery("from Admin where email=:param").setParameter("param",email).uniqueResult();
            session.close();
            return adminFound;
        }catch (Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
            session.close();
            return null;
        }
    }

    @Override
    public Admin findByPhone(String phone) {
        return null;
    }

    @Override
    public boolean createNew(Admin newO) {
        return false;
    }

    @Override
    public boolean update(Admin newO) {
        Session session = HibernateUtil.getSession().openSession();
        try {
            session.beginTransaction();
            session.update(newO);
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
    public Admin findByUsrName(String UsrName) {
        Session session = HibernateUtil.getSession().openSession();
        try{
            session.beginTransaction();
            Admin adminFound = (Admin) session.createQuery("from Admin where usrName=:param").setParameter("param",UsrName).uniqueResult();
            session.close();
            return adminFound;
        }catch (Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
            session.close();
            return null;
        }
    }
}
