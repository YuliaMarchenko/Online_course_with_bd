package com.example.online_course_with_bd.controller;

import com.example.online_course_with_bd.dto.CourseDTO;
import com.example.online_course_with_bd.dto.GetCoursesDTO;
import com.example.online_course_with_bd.service.CourseService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @PostMapping("/courses")
    public CourseDTO saveCourse(@RequestBody CourseDTO courseDTO) {
        return courseService.createCourse(courseDTO);
    }

    @GetMapping("/courses")
    public List<GetCoursesDTO> getCourses(@RequestParam(name = "showAll", required = false, defaultValue = "false") boolean showAll) {
        return courseService.getCourses(showAll);
    }

    @GetMapping("/courses/{id}")
    public CourseDTO getCourseInfo(@PathVariable("id") Long id) {
        return courseService.getCourse(id);
    }
}
