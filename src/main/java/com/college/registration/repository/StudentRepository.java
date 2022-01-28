package com.college.registration.repository;

import com.college.registration.controller.StudentController;
import com.college.registration.model.Student;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends CrudRepository<Student,Long>, JpaSpecificationExecutor<Student> {




    Iterable<Student>findAll();
}
