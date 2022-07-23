package com.example.cucumber.repository;

import com.example.cucumber.entity.Visa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface VisaRepository extends JpaRepository<Visa, Integer> {

    List<Visa> findByFirstNameStartingWith(String startsWith);
    List<Visa> findByDobBetween(Date from, Date to);

}
