package com.intraway.fizzbuzz.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intraway.fizzbuzz.domain.entities.Invocations;

public interface InvocationsRepository extends JpaRepository<Invocations, Integer>{

}
