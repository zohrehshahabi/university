package com.hib.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "T_StudentRegistration")
public class StudentRegistration {
    @EmbeddedId
    private StudentRegistrationId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("classroomId")
    private Classroom classroom;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("studentId")
    private Student student;

    @Column(name = "stg_grade")
    private Double grade ;

    public StudentRegistration() {
    }

    public StudentRegistration(Classroom classroom, Student student, Double grade) {
        this.classroom = classroom;
        this.student = student;
        this.grade = grade;
    }

    public StudentRegistrationId getId() {
        return id;
    }

    public void setId(StudentRegistrationId id) {
        this.id = id;
    }

    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentRegistration that = (StudentRegistration) o;
        return Objects.equals(id, that.id) && Objects.equals(classroom, that.classroom) && Objects.equals(student, that.student) && Objects.equals(grade, that.grade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, classroom, student, grade);
    }
}
