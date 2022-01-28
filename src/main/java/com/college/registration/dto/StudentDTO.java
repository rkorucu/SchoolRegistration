package com.college.registration.dto;

import com.college.registration.model.Course;
import com.college.registration.model.Student;
import com.college.registration.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

public class StudentDTO {
 private String fullName;
 private Long studentId;
 private Set<Course>registrationCourse=new HashSet<>();


    public StudentDTO(Student student) {
        this.fullName = student.getFullName();
        this.studentId = student.getStudentId();
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Set<Course> getRegistrationCourse() {
        return registrationCourse;
    }

    public void setRegistrationCourse(Set<Course> registrationCourse) {
        this.registrationCourse = registrationCourse;
    }
}
