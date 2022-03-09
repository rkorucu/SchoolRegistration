package com.college.registration.dto;

import com.college.registration.model.Course;

import java.util.HashSet;
import java.util.Set;

public class StudentDTO {

    private Long studentId;
    private String fullName;


    Set<Course> courses=new HashSet<>();



    public StudentDTO() {
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public Set<Course> getCourses() {
        return courses;
    }
}
