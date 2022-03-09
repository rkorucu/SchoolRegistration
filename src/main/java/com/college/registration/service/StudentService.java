package com.college.registration.service;


import com.college.registration.dto.StudentDTO;

import com.college.registration.model.Course;
import com.college.registration.model.Student;
import com.college.registration.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class StudentService {
    @Autowired
    CourseService  courseService;
    @Autowired
    StudentRepository studentRepository;


    // to get all students' information from database
    public Iterable<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Object addNewStudent(StudentDTO studentDTO) {
        Student student = new Student();
        studentDTO.setFullName(student.getFullName());
        return studentRepository.save(student).getStudentId();

    }

    // Find Student information by student id.
    public StudentDTO getStudentId(Long studentId) {
        Optional<Student> student = studentRepository.findById(studentId);
        if (student.isPresent()) {
            StudentDTO studentDTO = new StudentDTO();
            studentDTO.setFullName(student.get().getFullName());
            studentDTO.setStudentId(student.get().getStudentId());
            return studentDTO;
        }
        return null;
    }

    //Find student by student fullName
    public List<StudentDTO> getStudentFullName(String fullName) {
        return studentRepository.findByFullName(fullName).
                stream().map(this::convertToDto).collect(Collectors.toList());
    }


    /**
     * Yeni bir method yazarak getStudentDTO ogrecinin id ve ismini
     * Student modelini kullanarak  GetStudentDto set ediliyor.
     * Methodun yazilma amaci : sadece gerekli olan bilgiler user a  aktarilirsin.
     * Şimdi, is ve isim  nesnelerini tek bir GetStudentDto nesnesine eşlemenin bir yoluna ihtiyacımız olacak.
     */

    //Student den bilgiler alinarak StudentDTo set ediyoruz
    private StudentDTO convertToDto(Student student) {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setFullName(student.getFullName());
        studentDTO.setStudentId(student.getStudentId());
        return studentDTO;
    }


}









