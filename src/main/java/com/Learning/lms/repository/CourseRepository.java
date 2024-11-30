package com.Learning.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Learning.lms.model.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {
    
}
