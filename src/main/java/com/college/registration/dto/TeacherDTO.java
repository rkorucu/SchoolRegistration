package com.college.registration.dto;

import com.college.registration.model.Course;
import com.college.registration.model.Teacher;

import java.util.HashSet;
import java.util.Set;

public class TeacherDTO {
    private Long teacherId;
    private String fullName;

  private  Set<Course> courses=new HashSet<>();

    public TeacherDTO(Teacher teacher) {
        this. teacherId= teacher.getTeacherId();
        this.fullName = teacher.getFullName();
    }

    public TeacherDTO(){

  }

    public Long getCourseId() {
        return teacherId ;
    }

    public void setCourseId(Long courseId) {
        this. teacherId= courseId;
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

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }
}
