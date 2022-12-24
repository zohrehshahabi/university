package com.hib.repository.implemRepos;

import com.hib.hibernate.SessionFactoryProvider;
import com.hib.model.Course;
import com.hib.model.Person;
import com.hib.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class CourseImp {
    static SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();
    public Course createCourse(Course c) {
        Session session = sessionFactory.openSession();
        Transaction tr = session.beginTransaction();
        session.save(c);
        tr.commit();
        session.close();
        return c;
    }

    public void updateCourse(long id, Course c) {
        Session session = sessionFactory.openSession();
        Transaction tr = session.beginTransaction();
        Course c1 = session.get(Course.class, id);

        c1.setLevel(c.getLevel());
        c1.setTitle(c.getTitle());

        session.save(c1);
        tr.commit();
        session.close();
    }
    public Course getCourse(long id) {
        Session session = sessionFactory.openSession();
        Transaction tr=session.beginTransaction();
        Course c=session.get(Course.class,id);
        session.save(c);
        tr.commit();
        session.close();
        return  c;
    }
    // retrieve
    public List<Course> getCourseList() {
        Session session = sessionFactory.openSession();
        Transaction tr = session.beginTransaction();
        Query<Course> q = session.createQuery("from Course ");
        if (q.list() != null) {
            return q.list();
        }

        tr.commit();
        session.close();
        return null;
    }

    //    public void PersonUpdate(Person person,long id){
//        Session session = sessionFactory.openSession();
//        Transaction tr = session.beginTransaction();
//        String hql="UPDATE Person set fName = :fName " + "WHERE id = :PersonId";
//        Query query = session.createQuery(hql);
//        query.setParameter("fName",person.getfName() );
//        query.setParameter("PersonId", id);
//        int result = query.executeUpdate();
//        System.out.println("Rows affected: " + result);
//        //session.close();
//    }
    public void deleteCourse(long id) {
        Session session = sessionFactory.openSession();
        Transaction tr = session.beginTransaction();
        Course course = session.get(Course.class, id);
        session.delete(course);
        tr.commit();
        session.close();
    }
}
