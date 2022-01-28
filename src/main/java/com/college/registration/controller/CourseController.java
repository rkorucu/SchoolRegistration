package com.college.registration.controller;


import com.college.registration.model.Course;
import com.college.registration.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "courses")
public class CourseController {

    @Autowired
    CourseService courseService;
    @GetMapping
    public List<Course> getAllCourses(){
        return courseService.getAllCourse();
    }
    @PostMapping
   public Long addCourse(@RequestBody Course course){
       courseService.addCourse(course);
       return course.getCourseById();
    }

}
