package com.intraway.fizzbuzz.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intraway.fizzbuzz.domain.entities.OkInvocations;

/**
 * Objeto Repository de la entitie OkInvocations
 * @author Pablo Mendez
 *
 */
public interface OkInvocationsRepository extends JpaRepository<OkInvocations, Integer> {

}
