package com.example.online_course_with_bd.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "courseInfo")

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder

public class CourseInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "description")
    private String description;

    @Column(name = "startsOn")
    private LocalDate startsOn;

    @Column(name = "endsOn")
    private LocalDate endsOn;

    @Column(name = "lecturer")
    private String lecturer;
}
