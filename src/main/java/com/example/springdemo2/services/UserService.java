package com.example.springdemo2.services;

import com.example.springdemo2.entities.Users;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public interface UserService extends UserDetailsService {
    Users getUserByEmail(String email);
}
