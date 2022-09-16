package com.example.online_course_with_bd.repository;

import com.example.online_course_with_bd.entity.CourseInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseInfoRepository extends JpaRepository<CourseInfo, Long> {
}
