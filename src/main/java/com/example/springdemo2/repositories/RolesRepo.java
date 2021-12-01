package com.example.springdemo2.repositories;

import com.example.springdemo2.entities.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface RolesRepo extends JpaRepository<Roles,Long> {

}
