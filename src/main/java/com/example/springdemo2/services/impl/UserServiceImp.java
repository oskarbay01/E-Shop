package com.example.springdemo2.services.impl;

import com.example.springdemo2.entities.Users;
import com.example.springdemo2.repositories.UsersRepo;
import com.example.springdemo2.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UsersRepo usersRepo;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {


        Users myUser = usersRepo.findByEmail(s);
        if (myUser != null) {
            User secUser = new User(myUser.getEmail(), myUser.getPassword(), myUser.getRoles());
            return secUser;

        }
        throw new UsernameNotFoundException("User Not Found");

    }

    @Override
    public Users getUserByEmail(String email) {
        return usersRepo.findByEmail(email);
    }
}
