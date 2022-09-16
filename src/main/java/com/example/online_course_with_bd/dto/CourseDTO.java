package com.example.online_course_with_bd.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Builder
@Getter
@Setter
public class CourseDTO {
    private Long id;
    private String name;
    private String description;
    private String lecturer;
    private LocalDate startsOn;
    private LocalDate endsOn;
    private boolean isActive;
}
