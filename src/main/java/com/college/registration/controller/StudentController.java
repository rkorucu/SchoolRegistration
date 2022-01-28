package com.college.registration.controller;


import com.college.registration.model.Student;
import com.college.registration.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "students")
public class StudentController {
    @Autowired
    StudentService studentService;

    @GetMapping
    public List<Student> getAllStudents(){
        return (List<Student>) studentService.getAllStudents();
    }
    @PostMapping
    public Long registerNewStudent(@RequestBody Student student){
         return studentService.addNewStudent(student);
    }

}
