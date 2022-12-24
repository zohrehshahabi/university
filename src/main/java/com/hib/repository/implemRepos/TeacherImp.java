package com.hib.repository.implemRepos;

import com.hib.hibernate.SessionFactoryProvider;
import com.hib.model.Person;
import com.hib.model.Teacher;
import com.hib.repository.PersonReps;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class TeacherImp {
    static SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    public Teacher createTeacher(Teacher t) {
        Session session = sessionFactory.openSession();
        Transaction tr = session.beginTransaction();
        session.save(t);
        tr.commit();
        session.close();
        return t;
    }
    public Teacher getTeacher(long id) {
        Session session = sessionFactory.openSession();
        Transaction tr=session.beginTransaction();
        Teacher t=session.get(Teacher.class,id);
        session.save(t);
        tr.commit();
        session.close();
        return t;
    }
    public void updateTeacher(long id, Teacher t) {
        Session session = sessionFactory.openSession();
        Transaction tr = session.beginTransaction();
        Teacher t1 = session.get(Teacher.class, id);

        t1.setExperienceYear(t.getExperienceYear());
        session.save(t1);
        tr.commit();
        session.close();
    }



    public void deleteTeacher(long id) {
        Session session = sessionFactory.openSession();
        Transaction tr = session.beginTransaction();
        Teacher teacher = session.get(Teacher.class, id);
        session.delete(teacher);
        tr.commit();
        session.close();
    }


}
