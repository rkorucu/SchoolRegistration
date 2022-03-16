package com.college.registration.controller;

import com.college.registration.model.Course;
import com.college.registration.model.Student;
import com.college.registration.model.Teacher;
import com.college.registration.repository.CourseRepository;
import com.college.registration.repository.StudentRepository;
import com.college.registration.repository.TeacherRepository;
import com.college.registration.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/registration")
public class Registration {
    @Autowired
    CourseRepository courseRepository;
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    TeacherRepository teacherRepository;

    @PutMapping("courses/{courseId}/students/{studentId}")
    Course enrolledStudentToCourse(@PathVariable Long courseId , @PathVariable Long studentId){
        Course course = courseRepository.findById(courseId).get();
        Student student = studentRepository.findById(studentId).get();
        course.getEnrolledStudent(student);
        return courseRepository.save(course);
    }

    // assigned teacher each course. And Save in database.
    @PutMapping("courses/{courseId}/teachers/{teacherId}")
    Course assignTeacherToCourse(@PathVariable long courseId , @PathVariable long teacherId) {
        Course course = courseRepository.findById(courseId).get();
        Teacher teacher = teacherRepository.findById(teacherId).get();
        course.assignTeacher(teacher);
        return courseRepository.save(course);



    }

}
