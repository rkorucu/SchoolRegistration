package com.college.registration.service;


import com.college.registration.model.Course;
import com.college.registration.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
  @Autowired
   private CourseRepository courseRepository;


    public Iterable<Course> getAllCourse() {
        return courseRepository.findAll();
    }


    public Long addCourse(Course course) {
        courseRepository.save(course);
        return course.getCourseId();
    }
}
