package com.hib.repository.implemRepos;

import com.hib.hibernate.SessionFactoryProvider;
import com.hib.model.Person;
import com.hib.model.Student;
import com.hib.repository.PersonReps;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class StudentImp {
    static SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();


    public Student createStudent(Student s) {
        Session session = sessionFactory.openSession();
        Transaction tr = session.beginTransaction();
        session.save(s);
        tr.commit();
        session.close();
        return s;
    }

    public void updatePerson(long id, Person p) {
        Session session = sessionFactory.openSession();
        Transaction tr = session.beginTransaction();
        Person p1 = session.get(Person.class, id);

        p1.setfName(p.getfName());
        p1.setlName(p.getlName());


        session.save(p1);
        tr.commit();
        session.close();
    }

    // retrieve
    public List<Person> getPersonList() {
        Session session = sessionFactory.openSession();
        Transaction tr = session.beginTransaction();
        Query<Person> q = session.createQuery("from Person ");
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
    public void deleteStudent(long id) {
        Session session = sessionFactory.openSession();
        Transaction tr = session.beginTransaction();
        Student student = session.get(Student.class, id);
        session.delete(student);
        tr.commit();
        session.close();
    }


}
