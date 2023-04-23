package com.SportAcademy.Model;

import lombok.*;
import javax.persistence.*;
import javax.persistence.Id;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "course_cards")
public class CourseCards {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "courseFees")
    private String courseFees;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id", nullable = false,referencedColumnName = "id")
    private CourseDetails course;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "coach_id", nullable = false,referencedColumnName = "id")
    private CoachDetails coach;
}
