package com.hib.repository.implemRepos;

import com.hib.hibernate.SessionFactoryProvider;
import com.hib.model.Person;
import com.hib.repository.PersonReps;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class PersonImp  {
    static SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

//    @Override
    public Person createPerson(Person p) {
        Session session = sessionFactory.openSession();
        Transaction tr = session.beginTransaction();
        session.save(p);
        tr.commit();
        session.close();
        return p;
    }
    public Person getPerson(long id) {
        Session session = sessionFactory.openSession();
        Transaction tr=session.beginTransaction();
        Person p=session.get(Person.class,id);
        session.save(p);
        tr.commit();
        session.close();
        return  p;
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

//    public void deletePerson(long id) {
//        Session session = sessionFactory.openSession();
//        Transaction tr = session.beginTransaction();
//        Person person = session.get(Person.class, id);
//        session.delete(person);
//        tr.commit();
//        session.close();
//


}
