package com.intraway.fizzbuzz.services;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.intraway.fizzbuzz.domain.dto.ERRORFizzbuzzDTO;
import com.intraway.fizzbuzz.domain.dto.OKFizzbuzzDTO;
import com.intraway.fizzbuzz.domain.entities.Invocations;
import com.intraway.fizzbuzz.domain.entities.OkInvocations;
import com.intraway.fizzbuzz.domain.entities.Results;
import com.intraway.fizzbuzz.domain.repository.InvocationsRepository;
import com.intraway.fizzbuzz.domain.repository.OkInvocationsRepository;
import com.intraway.fizzbuzz.domain.repository.ResultsRepository;

@Service
public class FizzbuzzServicesImpl implements FizzbuzzServices {

	protected final InvocationsRepository invocationsRepository;
	protected final OkInvocationsRepository okInvocationsRepository;
	protected final ResultsRepository resultsRepository;

	@Value("${user-constants.string.multipleOf3}")
	private String multipleOf3;
	@Value("${user-constants.string.multipleOf5}")
	private String multipleOf5;
	@Value("${user-constants.string.multipleOf3and5}")
	private String multipleOf3and5;

	public FizzbuzzServicesImpl(InvocationsRepository aInvocationsRepository,
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

	@Override
	public boolean validateMinMax(String min, String max) {

		// Primero valido que son enteros y no nulos
		try {
			Integer.parseInt(min);
			Integer.parseInt(max);
		} catch (Exception e) {
			return false;
		}

		// Segundo valido que min es menor que max
		if (Integer.parseInt(min) <= Integer.parseInt(max))
			return true;

		return false;
	}

	@Override
	public OKFizzbuzzDTO getOkResult(String min, String max) {

		OKFizzbuzzDTO result = new OKFizzbuzzDTO();// Creo un new OKFizzbuzzDTO porque ya estan validados min y max

		List<String> resultList = new ArrayList<String>();// Lista para almacenar los resultados

		String description = "no se encontraron múltiplos de 3 ni de 5";
		boolean multiple3 = false;
		boolean multiple5 = false;

		for (int i = Integer.parseInt(min); i <= Integer.parseInt(max); i++) {

			search: {// Genero un bloque para agrupar los condicionales

				if (i % 3 == 0) {// Evaluo si es multiplo de 3
					resultList.add(multipleOf3);
					description = "se encontraron múltiplos de 3";
					multiple3 = true;
					break search;
				} else if (i % 5 == 0) {// Evaluo si es multiplo de 5
					resultList.add(multipleOf5);
					description = "se encontraron múltiplos de 5";
					multiple5 = true;
					break search;
				}
				resultList.add("" + i);
			}

		}

		if(multiple3 & multiple5) { description = "se encontraron múltiplos de 3 y de 5";}
		
		result.setCode("CODE??");
		result.setDescription(description);
		result.setTimestamp("" + new Timestamp(System.currentTimeMillis()).getTime());
		result.setList(String.join(",", resultList));

		return result;
	}

	@Override
	public ERRORFizzbuzzDTO getErrorResult(String path) {

		ERRORFizzbuzzDTO result = new ERRORFizzbuzzDTO();
		
		result.setError("Bad Request");
		result.setException("com.intraway.exceptions.badrequest");
		result.setMessage("Los parámetros enviados son incorrectos");
		result.setPath(path);
		result.setStatus(400);
		result.setTimestamp("" + new Timestamp(System.currentTimeMillis()).getTime());

		return result;
	}

}
