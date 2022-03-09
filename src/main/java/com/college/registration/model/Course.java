package com.college.registration.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name="courses")
public class Course {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)

    private Long courseId;

    @ManyToMany
    @JoinTable(name = "studentsEnrolled",
    //create first column to course inside table
    joinColumns =  @JoinColumn(name = "course_id"),
  // create second column for studentId .And relationship each other
     inverseJoinColumns = @JoinColumn(name = "student_id"))
  //It holds which course is student enroll
    private  Set<Student> enrolledStudents=new HashSet<>();



    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "teacher_id")
     private Teacher teacher;
    private String name;

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
    public Set<Student> getEnrolStudent() {
        return enrolledStudents;
    }


    public void getEnrolStudent(Student student) {
        enrolledStudents.add(student);
    }
    public Teacher getTeacher() {
        return teacher;
    }


    public void assignTeacher(Teacher teacher) {
        this.teacher=teacher;
    }


}


