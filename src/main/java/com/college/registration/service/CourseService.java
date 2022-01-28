package com.college.registration.service;


import com.college.registration.model.Course;
import com.college.registration.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CourseService {
  @Autowired
   private CourseRepository courseRepository;


    public List<Course> getAllCourse() {
        return courseRepository.getAllByOrderByName();
    }


    public Course addCourse(Course course) {
        return courseRepository.save(course);
    }
}
