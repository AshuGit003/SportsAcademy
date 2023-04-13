package com.SportAcademy.Service;

import com.SportAcademy.Model.UserDetails;
import org.springframework.stereotype.Service;


public interface UserService {
    public UserDetails createUser(UserDetails user);

    public boolean checkEmail(String email);
}
