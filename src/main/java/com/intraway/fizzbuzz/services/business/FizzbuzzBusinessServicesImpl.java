package com.intraway.fizzbuzz.services.business;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.intraway.fizzbuzz.domain.dto.ERRORFizzbuzzDTO;
import com.intraway.fizzbuzz.domain.dto.OKFizzbuzzDTO;
import com.intraway.fizzbuzz.domain.entities.Invocations;
import com.intraway.fizzbuzz.domain.entities.OkInvocations;
import com.intraway.fizzbuzz.domain.entities.Results;
import com.intraway.fizzbuzz.services.dao.FizzbuzzDAO;

@Service
public class FizzbuzzBusinessServicesImpl implements FizzbuzzBusinessServices {

	@Value("${user-constants.string.multipleOf3}")
	private String multipleOf3;
	@Value("${user-constants.string.multipleOf5}")
	private String multipleOf5;
	@Value("${user-constants.string.multipleOf3and5}")
	private String multipleOf3and5;

	@Autowired
	protected final FizzbuzzDAO fizzbuzzDAO;

	public FizzbuzzBusinessServicesImpl(FizzbuzzDAO aFizzbuzzDAO) {
		fizzbuzzDAO = aFizzbuzzDAO;
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
	public OKFizzbuzzDTO getOkResult(String min, String max, String path) {

		OKFizzbuzzDTO result = new OKFizzbuzzDTO();// Creo un new OKFizzbuzzDTO porque ya estan validados min y max

		List<String> resultList = new ArrayList<String>();// Lista para almacenar los resultados

		String description = "no se encontraron múltiplos de 3 ni de 5";
		boolean multiple3 = false;
		boolean multiple5 = false;

		for (int i = Integer.parseInt(min); i <= Integer.parseInt(max); i++) {

			search: {// Genero un bloque para agrupar los condicionales y de esta forma evito los
						// else, ya que al evaluar en verdadero un if no se evaluan los restantes ya que
						// esta el break del bloque dentro del cuerpo del condicional

				if (i % 3 == 0 & i % 5 == 0) {// Evaluo si es multiplo de los dos
					resultList.add(multipleOf3and5);
					multiple3 = true;
					multiple5 = true;
					break search;
				}
				if (i % 3 == 0) {// Evaluo si es multiplo de 3
					resultList.add(multipleOf3);
					description = "se encontraron múltiplos de 3";
					multiple3 = true;
					break search;
				}
				if (i % 5 == 0) {// Evaluo si es multiplo de 5
					resultList.add(multipleOf5);
					description = "se encontraron múltiplos de 5";
					multiple5 = true;
					break search;
				}
				resultList.add("" + i);
			}

		}

		if (multiple3 & multiple5) {
			description = "se encontraron múltiplos de 3 y de 5";
		}

		result.setCode("CODE??");
		result.setDescription(description);
		result.setTimestamp("" + new Timestamp(System.currentTimeMillis()).getTime());
		result.setPath(path);
		result.setList(String.join(",", resultList));

		persist(result, resultList);

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
		
		//TODO: Persistir el estado ERROR

		return result;
	}

	private void persist(OKFizzbuzzDTO okResult, List<String> aResultList) {

		OkInvocations okInvocation = new OkInvocations();
		okInvocation.setCode(okResult.getCode());
		okInvocation.setDescription(okResult.getDescription());

		List<Results> resultList = new ArrayList<Results>();
		Results result;
		for (String aResult : aResultList) {
			result = new Results();
			result.setValue(aResult);
			result.setOkInvocations(okInvocation);
			resultList.add(result);
		}

		okInvocation.setResults(resultList);

		Invocations invocation = new Invocations();
		invocation.setCreatedTime(new Timestamp(System.currentTimeMillis()));//TODO: cambiar este timestamp
		invocation.setPath(okResult.getPath());
		invocation.setState(true);
		invocation.setOkInvocations(okInvocation);

		okInvocation.setInvocations(invocation);

		fizzbuzzDAO.createInvocations(invocation);

	}

}
