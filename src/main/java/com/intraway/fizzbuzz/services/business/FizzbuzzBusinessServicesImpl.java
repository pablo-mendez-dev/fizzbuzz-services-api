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
import com.intraway.fizzbuzz.exceptions.AppBussinesException;
import com.intraway.fizzbuzz.services.dao.FizzbuzzDAO;

@Service
public class FizzbuzzBusinessServicesImpl implements FizzbuzzBusinessServices {

	// Inyecto los valores de constantes configuradas en el archivo de configuracion
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

		// Estas variable boolean permiten identificar que tipos de enteros hay y si
		// cumplen con las condiciones buscadas para tener una asignacion fizz o buzz
		boolean multiple3 = false;
		boolean multiple5 = false;

		try {
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
						multiple3 = true;
						break search;
					}
					if (i % 5 == 0) {// Evaluo si es multiplo de 5
						resultList.add(multipleOf5);
						multiple5 = true;
						break search;
					}
					resultList.add("" + i);
				}

			}

			if (multiple3 & multiple5) {// Si existen multiplos de los dos
				description = "se encontraron múltiplos de 3 y de 5";
			} else if (multiple3) {// No existen multiplos de los dos, pregunto si existen de 3
				description = "se encontraron múltiplos de 3";
			} else if (multiple5) {// No existen multiplos de los dos ni de 3, pregunto si existen de 5
				description = "se encontraron múltiplos de 5";
			}

			result.setCode(String.format("%03d", 2));
			result.setDescription(description);
			result.setTimestamp("" + new Timestamp(System.currentTimeMillis()).getTime());
			result.setPath(path);
			result.setList(String.join(",", resultList));

			persistOkResult(result, resultList);
		} catch (Exception e) {
			throw new AppBussinesException("RUNTIME-ERROR: ", e.getMessage());
		}

		return result;
	}

	@Override
	public ERRORFizzbuzzDTO getErrorResult(String path) {

		ERRORFizzbuzzDTO result = new ERRORFizzbuzzDTO();

		try {
			result.setError("Bad Request");
			result.setException("com.intraway.exceptions.badrequest");
			result.setMessage("Los parámetros enviados son incorrectos");
			result.setPath(path);
			result.setStatus(400);
			result.setTimestamp("" + new Timestamp(System.currentTimeMillis()).getTime());

			persistErrorResult(path);
			
		} catch (Exception e) {
			throw new AppBussinesException("RUNTIME-ERROR: ", e.getMessage());
		}

		return result;
	}

	private void persistOkResult(OKFizzbuzzDTO okResult, List<String> aResultList) {

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
		invocation.setCreatedTime(new Timestamp(Long.parseLong(okResult.getTimestamp())));
		invocation.setPath(okResult.getPath());
		invocation.setState(true);
		invocation.setOkInvocations(okInvocation);

		okInvocation.setInvocations(invocation);

		fizzbuzzDAO.createInvocations(invocation);

		invocation.getIdInvocation();

	}

	private void persistErrorResult(String path) {

		Invocations invocation = new Invocations();
		invocation.setCreatedTime(new Timestamp(System.currentTimeMillis()));
		invocation.setPath(path);
		invocation.setState(false);
		invocation.setOkInvocations(null);

		fizzbuzzDAO.createInvocations(invocation);

	}
}
