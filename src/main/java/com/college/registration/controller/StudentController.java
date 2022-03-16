package com.college.registration.controller;
import com.college.registration.dto.StudentDTO;
import com.college.registration.model.Course;
import com.college.registration.model.Student;
import com.college.registration.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Set;


@RestController
@RequestMapping(value = "/students")

public class StudentController {
    @Autowired
    StudentService studentService;

    @GetMapping
    public Iterable<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @PostMapping
    public Object registerNewStudent(@RequestBody StudentDTO studentDTO) {
        return studentService.addNewStudent(studentDTO);
    }

    //to request info  with studentId from database
//     @GetMapping("/{studentId}")
//    public Optional<Student> getStudentId(@PathVariable Long studentId){
//     return  studentService.getStudentById(studentId);
//    }
//

    //PathVariable annotation would be an endpoint that identifies an entity with a primary key:
    @GetMapping("/{studentId}")
    public StudentDTO getStudentId(@PathVariable Long studentId) {
        return studentService.getStudentId(studentId);
    }


//    //Query Path parameters
//    @GetMapping("/fullName")
//    public List<StudentDTO> getStudentFullName(@RequestParam String fullName) {
//        return studentService.getStudentFullName(fullName);
//
//    }

    //     this method is Path parameters
    @GetMapping(value = "/fullName/{fullName}")
    public List<StudentDTO> getStudentFullName(@PathVariable String fullName) {
        return studentService.getStudentFullName(fullName);
    }


        @GetMapping("/{studentId}/courses")
        public Set<Course> getStudentCourses (@PathVariable Long studentId){
            return studentService.getStudentCourses(studentId);
        }


        @GetMapping("/{studentId}/courses/{courseCredit}")
    public List<Course> getCourseListWithStudentIdByCourseCredits(@PathVariable long studentId,
                                                                  @PathVariable long courseCredit){
        return studentService.getCourseListWithStudentIdByCourseCredits(studentId,courseCredit);
        }

}




