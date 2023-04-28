package com.SportAcademy.Service;

import com.SportAcademy.Model.UserDetails;
import org.springframework.stereotype.Service;


public interface UserService {
    UserDetails createUser(UserDetails user);

    boolean checkEmail(String email);
}
