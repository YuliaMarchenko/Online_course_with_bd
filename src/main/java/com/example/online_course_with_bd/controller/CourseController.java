package com.example.online_course_with_bd.controller;

import com.example.online_course_with_bd.dto.CourseDTO;
import com.example.online_course_with_bd.service.CourseService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @PostMapping("/courses")
    public CourseDTO saveCourse(@RequestBody CourseDTO courseDTO) {
        return courseService.createCourse(courseDTO);
    }
}
