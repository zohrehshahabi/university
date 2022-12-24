package com.hib.service;

import com.hib.hibernate.SessionFactoryProvider;
import com.hib.model.Course;
import com.hib.model.Review;
import com.hib.repository.implemRepos.CourseImp;
import com.hib.repository.implemRepos.ReviewImp;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class ReviewService {
    static SessionFactory sessionFactory;
    static Session session;
    public static void main(String[] args) {
        sessionFactory = SessionFactoryProvider.getSessionFactory();
        session = sessionFactory.openSession();
        ReviewImp reviewImp=new ReviewImp();
//        CourseImp courseImp=new CourseImp();
//        Course c1=courseImp.getCourse(1);
//        Course c2=courseImp.getCourse(2);
//        Review review1=new Review("aali bod", new Date(),c1);
//        Review review2=new Review("bad", new Date(),c2);
//        Review review3=new Review("zaef", new Date(),c1);
//        Review review4=new Review("excelent", new Date(),c2);
//        reviewImp.createReview(review1);
//        reviewImp.createReview(review2);
//        reviewImp.createReview(review3);
//        reviewImp.createReview(review4);
        System.out.println(getCourseReview(1l));
        session.close();
        sessionFactory.close();
    }
    public static List<Review> getCourseReview(long courseId){
        session.beginTransaction();
        String str = "From review r inner join course c on r.id=c.id where c.id=:n" ;
        Query q=session.createQuery(str);
        q.setParameter("n",courseId);
        System.out.println(q.list());

        return q.list();

    }
    public Boolean deleteCourseReview(long courseId){
        session.beginTransaction();
        String str = "delete from review r where r.id in" +
                "From review r inner join course c on r.course.id=c.id";
        Query q=session.createQuery(str);
        q.setParameter("n",courseId);
        int result=q.executeUpdate();
        System.out.println(q.list().toString());

        if( result==0){
            return false;
        }else
            return true;

    }
}
