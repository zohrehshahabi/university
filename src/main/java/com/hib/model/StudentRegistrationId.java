package com.hib.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class StudentRegistrationId implements Serializable {
    @Column(name = "stg_std_id")
    private long studentId;
    @Column(name = "stg_cls_id")
    private long classroomId;

    public StudentRegistrationId() {
    }

    public StudentRegistrationId(long studentId, long classroomId) {
        this.studentId = studentId;
        this.classroomId = classroomId;
    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public long getClassroomId() {
        return classroomId;
    }

    public void setClassroomId(long classroomId) {
        this.classroomId = classroomId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentRegistrationId that = (StudentRegistrationId) o;
        return studentId == that.studentId && classroomId == that.classroomId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, classroomId);
    }
}
