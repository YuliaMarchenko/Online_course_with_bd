package com.example.online_course_with_bd.service;

import com.example.online_course_with_bd.dto.CourseDTO;
import com.example.online_course_with_bd.dto.GetCoursesDTO;
import com.example.online_course_with_bd.entity.Course;
import com.example.online_course_with_bd.entity.CourseInfo;
import com.example.online_course_with_bd.repository.CourseInfoRepository;
import com.example.online_course_with_bd.repository.CourseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("CourseService")
@AllArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final CourseInfoRepository courseInfoRepository;

    @Override
    public CourseDTO createCourse(CourseDTO courseDTO) {

        CourseInfo courseInfo = CourseInfo.builder()
                .description(courseDTO.getDescription())
                .startsOn(courseDTO.getStartsOn())
                .endsOn(courseDTO.getEndsOn())
                .lecturer(courseDTO.getLecturer())
                .build();

        courseInfo = courseInfoRepository.save(courseInfo);

        Course course = Course.builder()
                .name(courseDTO.getName())
                .isActive(true)
                .courseInfo(courseInfo)
                .build();

        course = courseRepository.save(course);

        courseDTO.setId(course.getId());

        return courseDTO;
    }

    @Override
    public List<GetCoursesDTO> getCourses() {
        return courseRepository.findAllActiveCourses().stream()
                .map(course -> GetCoursesDTO.builder().id(course.getId()).name(course.getName()).build())
                .toList();
    }
}
