package com.example.online_course_with_bd.service;

import com.example.online_course_with_bd.repository.CourseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service("CourseService")
@AllArgsConstructor
public class CourseServiceImpl implements CourseService{

    private final CourseRepository courseRepository;

}
