package com.intraway.fizzbuzz.domain.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.intraway.fizzbuzz.domain.entities.Invocations;

public interface InvocationsRepository extends JpaRepository<Invocations, Integer> {

	@Query(value = "SELECT * FROM fizzbuzz.invocations WHERE state = :state", nativeQuery = true)
	public Collection<Invocations> getAllInvocationsByState(@Param("state") boolean state);
}
