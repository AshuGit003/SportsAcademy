package com.SportAcademy.Repository;

import com.SportAcademy.Model.ApplicationForm;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ApplicationFormRepository extends JpaRepository<ApplicationForm,Integer> {

    Optional<ApplicationForm> findById(Long id);
}
