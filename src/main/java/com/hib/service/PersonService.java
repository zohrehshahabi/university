package com.hib.service;

import com.hib.hibernate.SessionFactoryProvider;
import com.hib.model.*;
import com.hib.repository.implemRepos.PersonImp;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.security.auth.login.Configuration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class PersonService {
    static SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    public static void main(String[] args) {

        PersonImp personImp=new PersonImp();
        Person p1=new Person("0481330643","azadeh","sharabi");
        Person p2=new Person("0481330649","zohreh","shahabi");
        Person p3=new Person("0481330609","aziz","rasooli");
        Person p4=new Person("0481330687","eman","akbari");
        personImp.createPerson(p1);
        personImp.createPerson(p2);
        personImp.createPerson(p3);
        personImp.createPerson(p4);
        System.out.println(personImp.getPersonList());
        personImp.updatePerson(1,p2);
        System.out.println( personImp.getPerson(1l));
    }



}
