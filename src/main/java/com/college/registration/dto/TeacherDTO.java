package com.college.registration.dto;

import com.college.registration.model.Course;
import com.college.registration.model.Teacher;

import java.util.HashSet;
import java.util.Set;

public class TeacherDTO {

    private String fullName;
    private Long teacherId;
   private Set<Course> courses=new HashSet<>();

   public TeacherDTO(){

  }
  public TeacherDTO(String fullName, Long teacherId) {
        this.fullName = fullName;
        this.teacherId = teacherId;
    }

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    public TeacherDTO(String fullName) {
        this.fullName = fullName;
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
