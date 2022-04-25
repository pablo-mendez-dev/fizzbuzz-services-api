package com.intraway.fizzbuzz.services.dao;

import java.util.Collection;

import org.springframework.stereotype.Service;

import com.intraway.fizzbuzz.domain.entities.Invocations;
import com.intraway.fizzbuzz.domain.entities.OkInvocations;
import com.intraway.fizzbuzz.domain.entities.Results;
import com.intraway.fizzbuzz.domain.repository.InvocationsRepository;
import com.intraway.fizzbuzz.domain.repository.OkInvocationsRepository;
import com.intraway.fizzbuzz.domain.repository.ResultsRepository;

/**
 * Servicio que implementa la interfaz que expone los metodos para la logica de acceso a datos
 * @author Pablo Mendez
 *
 */
@Service
public class FizzbuzzDAOImpl implements FizzbuzzDAO {

	protected final InvocationsRepository invocationsRepository;
	protected final OkInvocationsRepository okInvocationsRepository;
	protected final ResultsRepository resultsRepository;

	public FizzbuzzDAOImpl(InvocationsRepository aInvocationsRepository,
			OkInvocationsRepository aOkInvocationsRepository, ResultsRepository aResultsRepository) {

		invocationsRepository = aInvocationsRepository;
		okInvocationsRepository = aOkInvocationsRepository;
		resultsRepository = aResultsRepository;
	}

	/**
	 * Metodo que ejecuta el save de una entitie Invocation haciendo uso de JpaRepository
	 */
	@Override
	public void createInvocations(Invocations invocation) {
		invocationsRepository.save(invocation);

	}

	/**
	 * Metodo que ejecuta el save de una entitie okInvocation haciendo uso de JpaRepository
	 */
	@Override
	public void createOkInvocations(OkInvocations okInvocation) {
		okInvocationsRepository.save(okInvocation);

	}

	/**
	 * Metodo que ejecuta el save de una entitie Result haciendo uso de JpaRepository
	 */
	@Override
	public void createResults(Results result) {
		resultsRepository.save(result);

	}

	/**
	 * Metodo que busca todos las invocaciones haciendo uso de JpaRepository
	 */
	@Override
	public Collection<Invocations> getAllInvocations() {
		return invocationsRepository.findAll();
	}

	/**
	 * Metodo que busca todos las invocaciones con el atributo STATE = (valor true o false) haciendo uso de JpaRepository
	 */
	@Override
	public Collection<Invocations> getAllInvocationsByState(boolean state) {
		return invocationsRepository.getAllInvocationsByState(state);
	}

}
