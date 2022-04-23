package com.intraway.fizzbuzz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.intraway.fizzbuzz.domain.dto.OKFizzbuzzDTO;
import com.intraway.fizzbuzz.services.business.FizzbuzzBusinessServices;

@CrossOrigin
@RestController("api")
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class FizzbuzzAPIController {

	@Autowired
	FizzbuzzBusinessServices fizzbuzzServices;//Injection del servicio FizzbuzzBusinessServices

	@Autowired
	public FizzbuzzAPIController(FizzbuzzBusinessServices aFizzbuzzServices) {
		fizzbuzzServices = aFizzbuzzServices;
	}

	/**
	 * Servicio que devuelve el resultado de ejecutar el algoritmo de FizzBuzz sobre las variables recibidas en el path 
	 * @param min
	 * @param max
	 * @return
	 */
	@GetMapping(value = "/fizzbuzz/{min}/{max}")
	public ResponseEntity<Object> getFizzbuzz(@PathVariable("min") String min, @PathVariable("max") String max) {

		boolean okValues = fizzbuzzServices.validateMinMax(min, max);// Verifico que los valores de min y max sean
																		// validos

		if (okValues) {// Si min y max son validos entonces genero resultado OK
			OKFizzbuzzDTO result = fizzbuzzServices.getOkResult(min, max, "/intraway/api/fizzbuzz/" + min + "/" + max);
			return new ResponseEntity<>(result, HttpStatus.OK);
		} else {// Si min y max no son correctos genero resultado ERROR
			return new ResponseEntity<>(fizzbuzzServices.getErrorResult("/intraway/api/fizzbuzz/" + min + "/" + max),
					HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping(value = "/fizzbuzz/getAllOkResults")
	public ResponseEntity<Object> getAllOkResults() {

		return new ResponseEntity<>(fizzbuzzServices.getAllOkResult(), HttpStatus.OK);

	}

	@GetMapping(value = "/fizzbuzz/getAllErrorResult")
	public ResponseEntity<Object> getAllErrorResult() {

		return new ResponseEntity<>(fizzbuzzServices.getAllErrorResult(), HttpStatus.OK);

	}

}
