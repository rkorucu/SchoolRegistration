package com.college.registration.controller;


import com.college.registration.model.Course;
import com.college.registration.model.Student;
import com.college.registration.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/courses")

public class CourseController {

    @Autowired
    CourseService courseService;

    @GetMapping
    public Iterable<Course> getAllCourses(){
        return courseService.getAllCourse();
    }

    @PostMapping
   public Long addNewCourse(@RequestBody Course course){
     return courseService.addNewCourse(course);

    }

    @PutMapping("/{courseId}/students/{studentId}")
    Course enrolledStudentToCourse(@PathVariable Long courseId , @PathVariable Long studentId){
      return courseService.enrolledStudentToCourse(courseId,studentId);

    }
    @PutMapping("/{courseId}/teachers/{teacherId}")
    Course assignTeacherToCourse(@PathVariable Long courseId , @PathVariable Long teacherId){
        return courseService.assignTeacherToCourse(courseId,teacherId);

    }


    @GetMapping("/{courseId}/student")
    public List<Student> getStudentByCourse(@PathVariable Long courseId,
                                            @RequestParam(value = "fullName") String fullName){
        return courseService.getStudentByCourse(courseId,fullName);

    }


}