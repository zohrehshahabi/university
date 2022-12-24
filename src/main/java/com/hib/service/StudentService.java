package com.hib.service;

import com.hib.hibernate.SessionFactoryProvider;
import com.hib.model.*;
import com.hib.repository.implemRepos.PersonImp;
import com.hib.repository.implemRepos.StudentImp;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.HashMap;
import java.util.Map;

public class StudentService {
    static SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    public static void main(String[] args) {


      StudentImp studentImp = new StudentImp();

        PersonImp personImp = new PersonImp();
        Person p1 = personImp.getPerson(1l);
        Student s = new Student("12", p1);
        studentImp.createStudent(s);


        //studentImp.deleteStudent(1l);
    }
}
