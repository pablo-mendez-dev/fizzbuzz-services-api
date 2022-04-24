package com.intraway.fizzbuzz;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.Random;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.intraway.fizzbuzz.controller.FizzbuzzAPIController;

@SpringBootTest
class FizzbuzzServicesApiApplicationTests {

	@Autowired
	private FizzbuzzAPIController fizzbuzzApiController;
	
	/**
	 * Test que valida que el controller es generado al cargar el contexto de la aplicacion
	 */
	@Test
	void contextLoadsTest() {
		assertThat(fizzbuzzApiController).isNotNull();
	}

	/**
	 * Test que permite validar que el algoritmo FizzBuzz implementado funciona correctamente
	 * @throws IOException
	 */
	@Test
	public void fizzBuzzAlgorithmTest() throws IOException {

		//Genero dos numeros al azar del 0 al 10 y los paso por parametro al endpoint
		Random random = new Random();
		int min = random.nextInt(10);
		int max = random.nextInt(10);
		
		//Invocacion del endpoint que ejecuta el algoritmo FizzBuzz
		HttpUriRequest request = new HttpGet("http://localhost:8080/intraway/api/fizzbuzz/" + min + "/" + max);
		HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);

		if (min <= max) {
			//Si min es menor o igual que max espero un resultado Ok
			assertEquals(httpResponse.getStatusLine().getStatusCode(), HttpStatus.SC_OK);
		}else {
			//Si min es mayor que max espero un bad request como respuesta
			assertEquals(httpResponse.getStatusLine().getStatusCode(), HttpStatus.SC_BAD_REQUEST);
		}

	}

	/**
	 * Test que permite validar que la respuesta del endpoint es un objeto JSON
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	@Test
	public void validateResponseContentTypeIsJsonTest()
	  throws ClientProtocolException, IOException {
	 
	   // Given
	   String jsonMimeType = "application/json";
	   HttpUriRequest request = new HttpGet( "http://localhost:8080/intraway/api/fizzbuzz/6/15" );

	   // When
	   HttpResponse response = HttpClientBuilder.create().build().execute( request );

	   // Then
	   String mimeType = ContentType.getOrDefault(response.getEntity()).getMimeType();
	   assertEquals( jsonMimeType, mimeType );
	}

}
