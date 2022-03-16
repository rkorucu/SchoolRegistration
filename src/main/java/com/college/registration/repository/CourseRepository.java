package com.college.registration.repository;

import com.college.registration.model.Course;
import com.college.registration.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {


    List<Course> findByCourseCredit(Long courseCredits);




}
