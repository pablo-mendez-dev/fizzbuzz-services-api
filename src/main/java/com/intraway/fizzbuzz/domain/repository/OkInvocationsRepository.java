package com.intraway.fizzbuzz.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intraway.fizzbuzz.domain.entities.OkInvocations;

public interface OkInvocationsRepository extends JpaRepository<OkInvocations, Integer> {

}
