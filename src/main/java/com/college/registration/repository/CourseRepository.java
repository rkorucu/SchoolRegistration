package com.college.registration.repository;

import com.college.registration.model.Course;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CourseRepository extends CrudRepository<Course,Long>, JpaSpecificationExecutor<Course> {



    List<Course> getAllByOrderByName();






}
