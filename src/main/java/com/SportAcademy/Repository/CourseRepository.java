package com.SportAcademy.Repository;

import com.SportAcademy.Model.CourseDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CourseRepository extends JpaRepository<CourseDetails,Integer> {

    Optional<CourseDetails> findById(Long id);

    void deleteById(Long id);

    CourseDetails getById(Long id);
}
