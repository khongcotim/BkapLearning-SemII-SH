package com.implement;

import com.dao.IDao;
import com.entity.Employee;
import com.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class EmployeeImp implements IDao<Integer, Employee> {
    @Override
    public List<Employee> getAll() {
        Session session = HibernateUtil.getSession().openSession();
        session.beginTransaction();
        List<Employee> employees = session.createQuery("from Employee").list();
        session.close();
        return employees;
    }

    @Override
    public boolean create(Employee newV) {
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
    public boolean update(Employee newV) {
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
            int check_delete = session.createQuery("delete Employee where id=:params").setParameter("params",id).executeUpdate();
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
    public Employee findById(Integer id) {
        Session session = HibernateUtil.getSession().openSession();
        try {
            session.beginTransaction();
            Employee empFound = (Employee) session.createQuery("from Employee where id=:params").setParameter("params",id).uniqueResult();
            session.close();
            return empFound;
        }catch (Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
            session.close();
            return null;
        }
    }

    @Override
    public Employee findByName(String nameW) {
        Session session = HibernateUtil.getSession().openSession();
        try {
            session.beginTransaction();
            Employee empFound = (Employee) session.createQuery("from Employee where name=:params").setParameter("params",nameW).uniqueResult();
            session.close();
            return empFound;
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

            // Long: l?? wrapper class ?????i di???n x??? l?? ki???u d??? li???u <long>
            // HQL <=> SQL: b???ng >>> mapping >>> Object
            Long cnt = (Long) ss.createQuery("select COUNT(id) from Employee").uniqueResult();

            ss.close();

            return cnt.intValue();
        } catch (Exception e) {
            // TODO: handle exception
        }

        return 0;
    }

    @Override
    public List<Employee> pagination(int page, int itemOnPage) {
        Session session = HibernateUtil.getSession().openSession();

        // B???t ?????u giao d???ch
        session.beginTransaction();

        page = page < 0 ? 0 : page;

        // Th???c thi truy v???n: s??? d???ng ng??n ng??? truy v???n HQL <=> SQL
        List<Employee> lst = session.createQuery("from Employee").setFirstResult(page * itemOnPage) // Offset
                .setMaxResults(itemOnPage) // Fetch next
                .list();

        // ????ng k???t n???i
        session.close();

        return lst;
    }

    public List<Employee> searchByName(String keyword){
        String keywordTranslate = "%" + keyword + "%";
        System.out.println("keywordTranslate: " + keywordTranslate);
        Session session = HibernateUtil.getSession().openSession();
        try {
            session.beginTransaction();
            List<Employee> courseFound = session.createQuery("from Employee where name like :params").setParameter("params",keywordTranslate).list();
            return courseFound;
        }catch (Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
            session.close();
            return null;
        }

    }
}
