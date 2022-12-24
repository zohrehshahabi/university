package com.hib.repository.implemRepos;

import com.hib.hibernate.SessionFactoryProvider;
import com.hib.model.Classroom;
import com.hib.model.Course;
import com.hib.model.Person;
import com.hib.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.time.LocalDateTime;
import java.util.List;

public class ClassroomImp {
    static SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();
    public Classroom createClassroom(Classroom c) {
        Session session = sessionFactory.openSession();
        Transaction tr = session.beginTransaction();
        session.save(c);
        tr.commit();
        session.close();
        return c;
    }
    public void updateClassroom(long id, Classroom c) {
        Session session = sessionFactory.openSession();
        Transaction tr = session.beginTransaction();
        Classroom c1 = session.get(Classroom.class, id);


        session.save(c1);
        tr.commit();
        session.close();
    }
    public Classroom getClassroom(long id) {
        Session session = sessionFactory.openSession();
        Transaction tr=session.beginTransaction();
        Classroom c=session.get(Classroom.class,id);
        session.save(c);
        tr.commit();
        session.close();
        return  c;
    }
    // retrieve
    public List<Classroom> getClassroomList() {
        Session session = sessionFactory.openSession();
        Transaction tr = session.beginTransaction();
        Query<Classroom> q = session.createQuery("from Classroom ");
        if (q.list() != null) {
            return q.list();
        }

        tr.commit();
        session.close();
        return null;
    }


    public void deleteClassroom(long id) {
        Session session = sessionFactory.openSession();
        Transaction tr = session.beginTransaction();
        Classroom classroom = session.get(Classroom.class, id);
        session.delete(classroom);
        tr.commit();
        session.close();
    }
}
