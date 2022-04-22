package com.intraway.fizzbuzz.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intraway.fizzbuzz.domain.entities.Results;

public interface ResultsRepository extends JpaRepository<Results, Integer>{

}
