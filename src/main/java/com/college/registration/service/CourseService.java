package com.college.registration.service;


import com.college.registration.model.Course;
import com.college.registration.model.Student;
import com.college.registration.model.Teacher;
import com.college.registration.repository.CourseRepository;
import com.college.registration.repository.StudentRepository;
import com.college.registration.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private TeacherRepository teacherRepository;

    public Iterable<Course> getAllCourse() {
        return courseRepository.findAll();
    }

    public Long addNewCourse(Course course) {
    return   courseRepository.save(course).getCourseId();
    }

    public Course enrolledStudentToCourse(Long courseId, Long studentId) {
        Course course = courseRepository.findById(courseId).get();
        Student student = studentRepository.findById(studentId).get();
       course.getEnrolStudent(student);
        return courseRepository.save(course);
    }

    public Course assignTeacherToCourse(Long courseId, Long teacherId) {
        Course course = courseRepository.findById(courseId).get();
        Teacher teacher = teacherRepository.findById(teacherId).get();
        course.assignTeacher(teacher);
        return courseRepository.save(course);
    }


    public List<Student> getStudentByCourse(Long courseId, String fullName) {
      Set<Student> students=  courseRepository.findById(courseId).get().getEnrolStudent();
       // System.out.println(courseId);
       // System.out.println(fullName);
      List<Student>result=new ArrayList<>();

        for (Student student : students) {
        //    System.out.println(student.getFullName());
            if (student.getFullName().equalsIgnoreCase(fullName)) {
                result.add(student);
               // System.out.println(student);

            }

        }
      return result;
    }

}

