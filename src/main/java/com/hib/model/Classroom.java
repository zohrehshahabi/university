package com.hib.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "T_classroom")
public class Classroom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cls_id")
   private int id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "cls_startdate")
    private Date startDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cls_crs_id")
    private Course course;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cls_tch_id")
    private Teacher teacher;

    /*@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name= "T_studentregister" , joinColumns = @JoinColumn(name = "stg_cls_id"),
            inverseJoinColumns = @JoinColumn(name="stg_std_id") )
    private List<Student> students;
*/
    @OneToMany(
            mappedBy = "classroom",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<StudentRegistration> studentRegistrations = new ArrayList<>();

    public Classroom() {
    }

    public Classroom(Date startDate, Course course, Teacher teacher, List<StudentRegistration> studentRegistrations) {
        this.startDate = startDate;
        this.course = course;
        this.teacher = teacher;
        this.studentRegistrations = studentRegistrations;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<StudentRegistration> getStudentRegistrations() {
        return studentRegistrations;
    }

    public void setStudentRegistrations(List<StudentRegistration> studentRegistrations) {
        this.studentRegistrations = studentRegistrations;
    }
}
