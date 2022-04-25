package com.implement;

import com.dao.IAccount;
import com.entity.Teachers;
import com.util.HibernateUtil;
import org.hibernate.Session;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class TeacherAccImpIAcc implements IAccount<Integer, Teachers> {
    @Override
    public List<Teachers> getAllAcc() {
        Session session = HibernateUtil.getSession().openSession();
        try{
            session.beginTransaction();
            List<Teachers> teacherList = session.createQuery("from Teachers").list();
            session.close();
            return teacherList;
        }catch (Exception e){
            e.printStackTrace();
            session.close();
            session.getTransaction().rollback();
            return null;
        }
    }

    @Override
    public Teachers findByEmail(String email) {
        Session session = HibernateUtil.getSession().openSession();
        try{
            session.beginTransaction();
            Teachers teacherFound = (Teachers) session.createQuery("from Teachers where email=:param").setParameter("param",email).uniqueResult();
            session.close();
            return teacherFound;
        }catch (Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
            session.close();
            return null;
        }
    }

    @Override
    public Teachers findByPhone(String phone) {
        Session session = HibernateUtil.getSession().openSession();
        try{
            session.beginTransaction();
            Teachers teacherFound = (Teachers) session.createQuery("from Teachers where phone=:param").setParameter("param",phone).uniqueResult();
            session.close();
            return teacherFound;
        }catch (Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
            session.close();
            return null;
        }
    }
    public Teachers findById(int id) {
        Session session = HibernateUtil.getSession().openSession();
        try{
            session.beginTransaction();
            Teachers teacherFound = (Teachers) session.createQuery("from Teachers where id=:param").setParameter("param",id).uniqueResult();
            session.close();
            return teacherFound;
        }catch (Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
            session.close();
            return null;
        }
    }

    @Override
    public boolean createNew(Teachers newO) {
        Session session = HibernateUtil.getSession().openSession();
        try {
            session.beginTransaction();
            boolean check_insert = (boolean) session.save(newO);
            session.getTransaction().commit();
            if (check_insert==true)
                return true;
            else
                return false;
        }catch (Exception e){
            e.printStackTrace();
            session.close();
            session.getTransaction().rollback();
            return false;
        }
    }

    @Override
    public boolean update(Teachers newO) {
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
    public Teachers findByUsrName(String UsrName) {
        return null;
    }


}
