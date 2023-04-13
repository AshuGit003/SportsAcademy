package com.SportAcademy.config;

import com.SportAcademy.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        com.SportAcademy.Model.UserDetails user = userRepo.findByEmail(email);

        if (user != null) {
            return new CustomUserDetail(user);
        }
        throw new UsernameNotFoundException("User Not Available");
    }
}
