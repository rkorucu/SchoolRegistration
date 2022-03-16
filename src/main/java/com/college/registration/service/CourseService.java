package com.college.registration.service;
import com.college.registration.model.Course;
import com.college.registration.model.Student;
import com.college.registration.model.Teacher;
import com.college.registration.repository.CourseRepository;
import com.college.registration.repository.StudentRepository;
import com.college.registration.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getAllCourse() {
        return courseRepository.findAll();
    }

    public void addNewCourse(Course course) {
     courseRepository.save(course);
    }


    public List<Student> getStudentListByStudentName(Long courseId, String fullName) {
        Course course = courseRepository.findById(courseId).get();
        List<Student> studentList = new ArrayList<>();
        for (Student student : course.getEnrolledStudent()) {
            if (student.getFullName() != null && student.getFullName().equalsIgnoreCase(fullName)) {
                studentList.add(student);
            }
        }
        return studentList;
    }

    public List<Course> getCourseListByCourseCredit(Long courseCredit) {
     return courseRepository.findByCourseCredit(courseCredit);


    }
}

