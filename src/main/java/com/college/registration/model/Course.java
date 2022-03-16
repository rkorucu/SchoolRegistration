package com.college.registration.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name="courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long courseId;

    @Column(name = "name")
    private String name;

 @Column(name = "courseCredit")
 private Long courseCredit;


    @ManyToOne
    private Teacher teacher;


    @ManyToMany
    private  List<Student> enrolledStudent =new ArrayList<>();


    public List<Student> getEnrolledStudent() {
        return enrolledStudent;
    }

    public void setEnrolledStudent(List<Student> enrolledStudent) {
        this.enrolledStudent = enrolledStudent;
    }

    public Course() {
    }
    public Course(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }
    public Long getCourseCredit() {
        return courseCredit;
    }

    public void setCourseCredit(Long courseCredit) {
        this.courseCredit = courseCredit;
    }



    public void getEnrolledStudent(Student student) {
        enrolledStudent.add(student);
    }

    public Teacher getTeacher() {
        return teacher;
    }


    public void assignTeacher(Teacher teacher) {
        this.teacher=teacher;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", name='" + name + '\'' +
                ", courseCredit=" + courseCredit +
                ", teacher=" + teacher +
                ", enrolledStudent=" + enrolledStudent +
                '}';
    }


}


