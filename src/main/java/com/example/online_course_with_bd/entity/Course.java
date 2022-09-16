package com.example.online_course_with_bd.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "course")

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder

public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "isActive")
    boolean isActive;

    @OneToOne
    @JoinColumn(name = "course_info_id")
    CourseInfo courseInfo;
}
