package com.SportAcademy.Repository;

import com.SportAcademy.Model.CourseCards;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CourseCardRepository extends JpaRepository<CourseCards,Integer> {

    Optional<CourseCards> findById(Long id);
}
