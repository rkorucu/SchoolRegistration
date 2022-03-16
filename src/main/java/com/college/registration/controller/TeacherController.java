package com.college.registration.controller;

import com.college.registration.model.Teacher;
import com.college.registration.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/teachers")
public class TeacherController {
    @Autowired
    TeacherService teacherService;


    @GetMapping
  public List<Teacher> getAllTeacher() {
    return teacherService.getAllTeacher();

    }

      @PostMapping
      public void addNewTeacher(@RequestBody Teacher teacher){
        teacherService.addNewTeacher(teacher);
      }


}
