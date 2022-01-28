package com.college.registration.controller;

import com.college.registration.model.Teacher;
import com.college.registration.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "teachers")
public class TeacherController {
    @Autowired
    TeacherService teacherService;
    @GetMapping
  public Iterable<Teacher> getAllTeacher() {
        return teacherService.getAllTeacher();

    }

      @PostMapping
              public Long addNewTeacher(@RequestBody Teacher teacher){
        return teacherService.addTeacher(teacher);
      }


}
