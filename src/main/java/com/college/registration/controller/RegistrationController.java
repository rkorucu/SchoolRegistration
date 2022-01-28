package com.college.registration.controller;

import com.college.registration.model.Course;
import com.college.registration.model.Student;
import com.college.registration.model.Teacher;
import com.college.registration.repository.CourseRepository;
import com.college.registration.repository.StudentRepository;
import com.college.registration.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("registration")
public class RegistrationController {
@Autowired
    StudentRepository studentRepository;
@Autowired
    TeacherRepository teacherRepository;
@Autowired
    CourseRepository courseRepository;

@PutMapping(value = "courses/{courseId}/student/{studentId}")

    public void registerNewStudent(@PathVariable Long studentId,@PathVariable Long courseId){
    try{
        Student student=studentRepository.findById(studentId).get();
        Course course=courseRepository.findById(courseId).get();
        course.getRegisteredNewStudent().add(student);
        courseRepository.save(course);
    }catch (Exception e){
        System.out.println(e.toString());

    }
}
@PutMapping(value = "courses/{courseId}/teacher/{teacherId}")
    public void registeredTeacher(@PathVariable Long teacherId,@PathVariable Long courseId){
    try {
        Teacher teacher=teacherRepository.findById(teacherId).get();
        Course course=courseRepository.findById(courseId).get();
        course.setTeacher(teacher);
        courseRepository.save(course);
    }catch(Exception e){
        System.out.println(e.toString());
    }

}

}
