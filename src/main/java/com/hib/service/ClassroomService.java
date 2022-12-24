package com.hib.service;

import com.hib.model.Classroom;
import com.hib.model.Course;
import com.hib.model.Teacher;
import com.hib.repository.implemRepos.ClassroomImp;
import com.hib.repository.implemRepos.CourseImp;
import com.hib.repository.implemRepos.PersonImp;
import com.hib.repository.implemRepos.TeacherImp;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

public class ClassroomService {
    public static void main(String[] args) {
        ClassroomImp classroomImp = new ClassroomImp();
//        String dateInString1 = "22/08/1987";
//        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
//        Date date1 = format.parse(dateInString1);
        CourseImp courseImp = new CourseImp();
        Course c1 = courseImp.getCourse(1);

        TeacherImp teacherImp = new TeacherImp();
        Teacher teacher=teacherImp.getTeacher(1);


      //  Classroom cr = new Classroom(new Date(),c1,teacher, )

    }
}
