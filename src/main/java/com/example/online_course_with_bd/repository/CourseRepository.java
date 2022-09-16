package com.example.online_course_with_bd.repository;

import com.example.online_course_with_bd.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
public interface CourseRepository extends JpaRepository<Course, Long> {
}
