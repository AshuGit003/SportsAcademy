package com.SportAcademy.Service;

import com.SportAcademy.Model.UserDetails;
import com.SportAcademy.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private BCryptPasswordEncoder passwordEncode;

    @Override
    public UserDetails createUser(UserDetails user) {
        user.setPassword(passwordEncode.encode(user.getPassword()));
        user.setRole("ROLE_USER");
        return userRepo.save(user);
    }

    @Override
    public boolean checkEmail(String email) {
        return userRepo.existsByEmail(email);
    }
}
