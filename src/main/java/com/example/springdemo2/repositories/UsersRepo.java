package com.example.springdemo2.repositories;

import com.example.springdemo2.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


public interface UsersRepo extends JpaRepository<Users,Long> {
    Users findByEmail(String email);
}
