package com.college.registration.service;

import com.college.registration.model.Teacher;
import com.college.registration.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {
    @Autowired
    TeacherRepository teacherRepository;
    public Iterable<Teacher> getAllTeacher() {
        return teacherRepository.findAll();
    }

    public Long addTeacher(Teacher teacher) {
        teacherRepository.save(teacher);
        return teacher.getTeacherId();
    }
}
