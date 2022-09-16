package com.example.online_course_with_bd.repository;

import com.example.online_course_with_bd.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {
    @Query("SELECT c FROM Course c WHERE c.isActive = true")
    List<Course> findAllActiveCourses();
}
