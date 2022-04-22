package com.intraway.fizzbuzz.services.dao;

import java.util.Collection;

import org.springframework.stereotype.Service;

import com.intraway.fizzbuzz.domain.entities.Invocations;
import com.intraway.fizzbuzz.domain.entities.OkInvocations;
import com.intraway.fizzbuzz.domain.entities.Results;
import com.intraway.fizzbuzz.domain.repository.InvocationsRepository;
import com.intraway.fizzbuzz.domain.repository.OkInvocationsRepository;
import com.intraway.fizzbuzz.domain.repository.ResultsRepository;

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

	@Override
	public void createInvocations(Invocations invocation) {
		invocationsRepository.save(invocation);

	}

	@Override
	public void createOkInvocations(OkInvocations okInvocation) {
		okInvocationsRepository.save(okInvocation);

	}

	@Override
	public void createResults(Results result) {
		resultsRepository.save(result);

	}

	@Override
	public Collection<Invocations> getAllInvocations() {
		return invocationsRepository.findAll();
	}

}
