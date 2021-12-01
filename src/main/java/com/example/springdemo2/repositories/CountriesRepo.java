package com.example.springdemo2.repositories;

import com.example.springdemo2.entities.Countries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface CountriesRepo extends JpaRepository<Countries,Long> {

}
