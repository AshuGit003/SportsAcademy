package com.SportAcademy.Model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "course")
public class CourseDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String courseName;

    @Column(nullable = false)
    private String courseDescription;

    @Column(nullable = false)
    private String courseFees;
}

