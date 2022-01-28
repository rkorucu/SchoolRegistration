package com.college.registration.service;

import com.college.registration.model.Student;
import com.college.registration.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;
    public Iterable<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Long addNewStudent(Student student) {
        studentRepository.save(student);
        return student.getStudentId();
    }
}
