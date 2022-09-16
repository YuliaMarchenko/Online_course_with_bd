package com.example.online_course_with_bd.service;

import com.example.online_course_with_bd.dto.CourseDTO;
import com.example.online_course_with_bd.dto.GetCoursesDTO;

import java.util.List;

public interface CourseService {
    CourseDTO createCourse (CourseDTO courseDTO);
    List<GetCoursesDTO> getCourses(boolean showAll);
}
