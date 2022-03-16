package com.college.registration.service;


import com.college.registration.dto.StudentDTO;

import com.college.registration.model.Course;
import com.college.registration.model.Student;
import com.college.registration.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class StudentService {
    @Autowired
    CourseService courseService;
    @Autowired
    StudentRepository studentRepository;


    // to get all students' information from database
    public Iterable<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Object addNewStudent(StudentDTO studentDTO) {
        Student student = new Student();
        student.setFullName(studentDTO.getFullName());
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
     * By writing a new method, getStudentDTO student's id and name
     * GetStudentDto is set using Student model.
     * The purpose of writing the method: only necessary information is transferred to the user.
     * Now we'll need a way to map the is and name objects to a single GetStudentDto object.
     */


    private StudentDTO convertToDto(Student student) {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setFullName(student.getFullName());
        studentDTO.setStudentId(student.getStudentId());
        return studentDTO;
    }

    // get courses list which enrolled student with id
    public Set<Course> getStudentCourses(Long studentId) {
        Optional<Student> student = studentRepository.findById(studentId);
        if (student.isEmpty() || student.get().getCourses() == null) {
            return null;
        }
        return student.get().getCourses();
    }

    public List<Course> getCourseListWithStudentIdByCourseCredits(Long studentId, Long courseCredit) {
        Student student = studentRepository.findById(studentId).get();

        List<Course>courseList=new ArrayList<>();

        for (Course course:student.getCourses()){
            if(student.getStudentId()!=null && course.getCourseCredit().equals(courseCredit)){
                courseList.add(course);
            }
        }
return courseList;
    }
}











