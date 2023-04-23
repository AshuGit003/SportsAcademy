package com.SportAcademy.Model;

import lombok.*;
import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "coach")
public class CoachDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String phoneNumber;

    @Column(nullable = true)
    private String description;

    @OneToMany(mappedBy = "coach", cascade = CascadeType.ALL)
    private Set<CourseCards> courseCards;
}
