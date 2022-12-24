package com.hib.service;

import com.hib.model.Person;
import com.hib.model.Student;
import com.hib.model.Teacher;
import com.hib.repository.implemRepos.PersonImp;

import com.hib.repository.implemRepos.TeacherImp;

public class TeacherService {
    public static void main(String[] args) {
        TeacherImp teacherImp = new TeacherImp();

        PersonImp personImp = new PersonImp();
        Person p1 = personImp.getPerson(1l);
        Teacher teacher = new Teacher(2,p1);
        teacherImp.createTeacher(teacher);
    }


}
