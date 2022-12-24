package com.hib.model;

import javax.persistence.*;

@Entity
@Table(name = "T_teacher")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tch_id")
    private long id;

    @Column(name = "tch_experienceyear")
    private int experienceYear;

    @OneToOne(cascade =CascadeType.ALL)
    @JoinColumn(name="tch_prs_id")
    private Person person;

    public Teacher() {
    }

    public Teacher(int experienceYear, Person person) {
        this.experienceYear = experienceYear;
        this.person = person;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getExperienceYear() {
        return experienceYear;
    }

    public void setExperienceYear(int experienceYear) {
        this.experienceYear = experienceYear;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", experienceYear=" + experienceYear +
                ", person=" + person +
                '}';
    }
}
