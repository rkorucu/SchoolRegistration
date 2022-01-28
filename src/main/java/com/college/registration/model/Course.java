package com.college.registration.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="courses")
public class Course {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
@Column(name = "name")
    private String name;


    @ManyToOne
    @JoinColumn(name = "teacher_teacher_id")
    private Teacher teacher;

    @ManyToMany
   private Set<Student> registeredNewStudent=new HashSet<>();

    public Set<Student> getRegisteredNewStudent() {
        return registeredNewStudent;
    }

    public void setRegisteredNewStudent(Set<Student> registeredStudent) {
        this.registeredNewStudent = registeredStudent;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public Course() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Long getCourseById() {
        return getCourseById();
    }
    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }


}
