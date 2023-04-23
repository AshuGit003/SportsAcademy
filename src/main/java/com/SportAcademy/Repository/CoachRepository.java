package com.SportAcademy.Repository;

import com.SportAcademy.Model.CoachDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CoachRepository extends JpaRepository<CoachDetails,Integer> {

    Optional<CoachDetails> findById(Long id);

    void deleteById(Long id);

    CoachDetails getById(Long id);
}
