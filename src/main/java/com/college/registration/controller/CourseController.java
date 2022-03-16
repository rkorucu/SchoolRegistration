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
   private CourseService courseService;

    @GetMapping
    public List<Course> getAllCourses(){
        return courseService.getAllCourse();
    }

    @PostMapping
   public void addNewCourse(@RequestBody Course course){
      courseService.addNewCourse(course);
    }


    @GetMapping("/{courseId}/student")
    public List<Student> getStudentListByStudentName(@PathVariable Long courseId,
                                            @RequestParam(value = "fullName") String fullName){
        return courseService.getStudentListByStudentName(courseId,fullName);

    }

    @GetMapping("/{courseCredit}")
    public List<Course> getCourseByCourseListCredit(@PathVariable Long courseCredit){
        return courseService.getCourseListByCourseCredit(courseCredit);
    }

}