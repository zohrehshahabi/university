package com.hib.model;

import javax.persistence.*;
import java.util.Map;

@Entity
@Table(name="T_Person")
public class Person {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "prs_id")
    private Long id;

    @Column(name = "prs_nationalCode")
    private String nationalCode;

    @Column(name = "prs_fname")
    private String fName;

    @Column(name = "prs_lname")
    private String lName;

    public static void printmsg(String msg){
        System.out.println(msg);
    }
    public Person() {
    }

    public Person(String nationalCode, String fName, String lName) {
        this.nationalCode = nationalCode;
        this.fName = fName;
        this.lName = lName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", nationalCode='" + nationalCode + '\'' +
                ", fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                '}';
    }
}


