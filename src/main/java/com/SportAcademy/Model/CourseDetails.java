package com.SportAcademy.Model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "course")
public class CourseDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String courseName;

    @Column(nullable = false)
    private String courseDescription;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private Set<CourseCards> courseCards;

}

