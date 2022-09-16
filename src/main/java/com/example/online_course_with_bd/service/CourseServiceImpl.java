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
    public List<GetCoursesDTO> getCourses(boolean showAll) {

        List<Course> result;

        if (showAll) {
            result = courseRepository.findAll();
        } else {
            result = courseRepository.findAllActiveCourses();
        }

        return result.stream()
                .map(course -> GetCoursesDTO.builder().id(course.getId()).name(course.getName()).build())
                .toList();
    }

    @Override
    public CourseDTO getCourse(Long id) {
        Course course = courseRepository.findById(id).get();
        return CourseDTO.builder().id(course.getId())
                .name(course.getName())
                .description(course.getCourseInfo().getDescription())
                .startsOn(course.getCourseInfo().getStartsOn())
                .endsOn(course.getCourseInfo().getEndsOn())
                .lecturer(course.getCourseInfo().getLecturer())
                .isActive(course.isActive()).build();
    }
}
