package com.example.online_course_with_bd.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class GetCoursesDTO {
    private Long id;
    private String name;
}
