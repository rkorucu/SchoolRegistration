package com.college.registration.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="students")
public class Student {

   @Id
   @GeneratedValue(strategy= GenerationType.AUTO)
    private long studentId;


    @Column(name = "fullName")
    private String fullName;

   @JsonIgnore
   @ManyToMany(mappedBy = "enrolledStudent")
    private  Set<Course> courses=new HashSet<>();

   public Student() {
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

    public Student(String fullName) {
        this.fullName = fullName;
    }
    public Set<Course> getCourses() {
        return courses;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", fullName='" + fullName + '\'' +
                '}';
    }


}
