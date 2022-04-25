package com.intraway.fizzbuzz.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intraway.fizzbuzz.domain.entities.Results;

/**
 * Objeto Repository de la entitie Results
 * @author Pablo Mendez
 *
 */
public interface ResultsRepository extends JpaRepository<Results, Integer> {

}
