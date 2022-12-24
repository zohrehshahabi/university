package com.hib.service;

import com.hib.model.Course;
import com.hib.repository.implemRepos.CourseImp;
import com.hib.repository.implemRepos.PersonImp;

public class CourseService {
    public static void main(String[] args) {
        CourseImp courseImp=new CourseImp();
        Course course1=new Course("math","2");
        Course course2=new Course("physics","3");
        Course course3=new Course("chemistry","4");
        courseImp.createCourse(course1);
        courseImp.createCourse(course2);
        courseImp.createCourse(course3);

    }
}
