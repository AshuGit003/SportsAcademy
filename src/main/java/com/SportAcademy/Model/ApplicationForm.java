package com.SportAcademy.Model;

import lombok.*;
import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "application_form")
public class ApplicationForm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "dob")
    private String dob;

    @Column(name = "gender")
    private String gender;

    @Column(name = "nationality")
    private String nationality;

    @Column(name = "emailAddress")
    private String emailAddress;

    @Column(name = "contactNumber")
    private String contactNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id", nullable = false,referencedColumnName = "id")
    private CourseDetails course;

    @Column(name="expertiseLevel")
    private String levelOfExpertise;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "coach_id", nullable = false,referencedColumnName = "id")
    private CoachDetails coach;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_card_id", nullable = false,referencedColumnName = "id")
    private CourseCards courseCards;

    @Column(name="experience")
    private String playingExperience;

}
