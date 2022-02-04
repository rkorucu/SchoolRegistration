package com.college.registration.repository;

import com.college.registration.model.Teacher;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TeacherRepository extends CrudRepository<Teacher,Long>, JpaSpecificationExecutor {
    Iterable<Teacher> findAll();





}

