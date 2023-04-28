package com.SportAcademy.Repository;

import com.SportAcademy.Model.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <UserDetails,Integer> {

    Boolean existsByEmail(String email);

    UserDetails findByEmail(String email);
}
