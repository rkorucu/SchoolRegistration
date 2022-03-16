package com.college.registration.service;

import com.college.registration.model.Teacher;
import com.college.registration.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {
    @Autowired
    TeacherRepository teacherRepository;


    public List<Teacher> getAllTeacher() {
        return teacherRepository.findAll();
    }

    public void addNewTeacher(Teacher teacher) {
         teacherRepository.save(teacher);

    }
}
