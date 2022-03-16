package com.college.registration.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="teachers")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long teacherId;

    @Column(name = "fullName")
    private String fullName;

    @JsonIgnore
    @OneToMany(mappedBy = "teacher")

    private final Set<Course> courses=new HashSet<>();

    public Teacher() {
    }

    public Teacher(String fullName) {
        this.fullName = fullName;
    }

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
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
