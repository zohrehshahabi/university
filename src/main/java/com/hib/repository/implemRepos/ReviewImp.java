package com.hib.repository.implemRepos;

import com.hib.hibernate.SessionFactoryProvider;
import com.hib.model.Course;
import com.hib.model.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class ReviewImp {
    static SessionFactory sessionFactory;
    static Session session;
//    public List<Review> getCourseReview(long courseId){
//        session.beginTransaction();
//        String str = "From course c left outer join review r on r.id=c.id where c.id=:n" ;
//        Query q=session.createQuery(str);
//        q.setParameter("n",courseId);
//        System.out.println(q.list());
//
//        return q.list();
//
//
//
//    }
    public Review createReview(Review r) {
        Session session = sessionFactory.openSession();
        Transaction tr = session.beginTransaction();
        session.save(r);
        tr.commit();
        session.close();
        return r;
    }

    public void updateReview(long id, Review r) {
        Session session = sessionFactory.openSession();
        Transaction tr = session.beginTransaction();
        Review r1 = session.get(Review.class, id);

        session.save(r1);
        tr.commit();
        session.close();
    }
    public Review getReview(long id) {
        Session session = sessionFactory.openSession();
        Transaction tr=session.beginTransaction();
        Review r=session.get(Review.class,id);
        session.save(r);
        tr.commit();
        session.close();
        return r;
    }
    // retrieve
//    public List<Course> getCourseList() {
//        Session session = sessionFactory.openSession();
//        Transaction tr = session.beginTransaction();
//        Query<Course> q = session.createQuery("from Course ");
//        if (q.list() != null) {
//            return q.list();
//        }
//
//        tr.commit();
//        session.close();
//        return null;
//    }

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
    public void deleteReview(long id) {
        Session session = sessionFactory.openSession();
        Transaction tr = session.beginTransaction();
        Review review = session.get(Review.class, id);
        session.delete(review);
        tr.commit();
        session.close();
    }
}
