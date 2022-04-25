package com.implement;

import com.dao.IDao;
import com.entity.Course;
import com.entity.Course;
import com.entity.Lesson;
import com.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class CourseImp implements IDao<Integer, Course> {
    @Override
    public List<Course> getAll() {
        Session session = HibernateUtil.getSession().openSession();
        try {
            session.beginTransaction();
            List courses = session.createQuery("from Course").list();
            session.close();
            return courses;
        }catch (Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
            session.close();
            return null;
        }
    }

    @Override
    public boolean create(Course newV) {
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
    public boolean update(Course newV) {
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
            int check_delete = session.createQuery("delete Course where id=:params").setParameter("params",id).executeUpdate();
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
    public Course findById(Integer id) {
        Session session = HibernateUtil.getSession().openSession();
        try {
            session.beginTransaction();
            Course courseFound = (Course) session.createQuery("from Course where id=:params").setParameter("params",id).uniqueResult();
            session.close();
            return courseFound;
        }catch (Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
            session.close();
            return null;
        }
    }

    @Override
    public Course findByName(String nameW) {
        Session session = HibernateUtil.getSession().openSession();
        try {
            session.beginTransaction();
            Course courseFound = (Course) session.createQuery("from Course where name=:params").setParameter("params",nameW).uniqueResult();
            session.close();
            return courseFound;
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
            Long cnt = (Long) ss.createQuery("select COUNT(id) from Course").uniqueResult();

            ss.close();

            return cnt.intValue();
        } catch (Exception e) {
            // TODO: handle exception
        }

        return 0;
    }

    @Override
    public List<Course> pagination(int page, int itemOnPage) {
        Session session = HibernateUtil.getSession().openSession();

        // Bắt đầu giao dịch
        session.beginTransaction();

        page = page < 0 ? 0 : page;

        // Thực thi truy vấn: sử dụng ngôn ngữ truy vấn HQL <=> SQL
        List<Course> lst = session.createQuery("from Course").setFirstResult(page * itemOnPage) // Offset
                .setMaxResults(itemOnPage) // Fetch next
                .list();

        // Đóng kết nối
        session.close();

        return lst;
    }

    public List<Course> searchByName(String keyword){
        String keywordTranslate = "%" + keyword + "%";
        System.out.println("keywordTranslate: " + keywordTranslate);
        Session session = HibernateUtil.getSession().openSession();
        try {
            session.beginTransaction();
            List<Course> courseFound = session.createQuery("from Course where name like :params").setParameter("params",keywordTranslate).list();
            return courseFound;
        }catch (Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
            session.close();
            return null;
        }

    }

    public List<Course> findByCate(int cate_id){
        Session session = HibernateUtil.getSession().openSession();
        try {
            session.beginTransaction();
            List<Course> courses = session.createQuery("from Course where category.id=:params").setParameter("params",cate_id).list();
            session.close();
            return courses;
        }catch (Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
            session.close();
            return null;
        }

    }

    public List<Lesson> getLessonByCourse(int course_id){
        Session session = HibernateUtil.getSession().openSession();
        try{
            session.beginTransaction();
            List<Lesson> lessonList = session.createQuery("from Lesson where course.id = :param").setParameter("param", course_id).list();
            return lessonList;
        }catch (Exception e){
            e.printStackTrace();
            session.close();
            return null;
        }
    }

    public List<Course> getCourseByTeacher(int idTeacher){
        Session session = HibernateUtil.getSession().openSession();
        try {
            session.beginTransaction();
            List courses = session.createQuery("from Course where teachers.id =:param").setParameter("param",idTeacher).list();
            session.close();
            return courses;
        }catch (Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
            session.close();
            return null;
        }
    }
}
