package com.college.registration.repository;

import com.college.registration.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

    List<Student> findByFullName(String fullName);



}
