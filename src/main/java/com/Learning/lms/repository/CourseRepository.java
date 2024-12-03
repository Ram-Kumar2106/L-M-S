// CourseRepository.java
package com.Learning.lms.repository;

import com.Learning.lms.model.Course;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findByCategory(String category);
    List<Course> findByPriceLessThan(BigDecimal price);
    List<Course> findByTitleContainingIgnoreCase(String title);
}
