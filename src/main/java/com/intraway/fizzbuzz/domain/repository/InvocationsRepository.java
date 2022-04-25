package com.intraway.fizzbuzz.domain.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.intraway.fizzbuzz.domain.entities.Invocations;

/**
 * Objeto Repository de la entitie Invocations
 * @author Pablo Mendez
 *
 */
public interface InvocationsRepository extends JpaRepository<Invocations, Integer> {

	/**
	 * Native Query que devuelve todos los resultados que tienen el atributo STATE igual al valor pasado por parametro
	 * @param state
	 * @return
	 */
	@Query(value = "SELECT * FROM fizzbuzz.invocations WHERE state = :state", nativeQuery = true)
	public Collection<Invocations> getAllInvocationsByState(@Param("state") boolean state);
}
