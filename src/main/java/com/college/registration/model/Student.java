package com.college.registration.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="students")
public class Student {

   @Id
   @GeneratedValue(strategy= GenerationType.AUTO)
    private Long studentId;
    private String fullName;

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
}
