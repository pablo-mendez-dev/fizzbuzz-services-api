package com.intraway.fizzbuzz;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.Random;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FizzbuzzServicesApiApplicationTests {

	@Test
	void contextLoads() {
		// Assertions.assertThat(fizzbuzzApiController).isNot(null);
	}

	@Test
	public void fizzbuzzTest() throws IOException {

		Random random = new Random();
		int min = random.nextInt(10);
		int max = random.nextInt(10);
		HttpUriRequest request = new HttpGet("http://localhost:8080/intraway/api/fizzbuzz/" + min + "/" + max);
		HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);

		if (min <= max) {
			assertEquals(httpResponse.getStatusLine().getStatusCode(), HttpStatus.SC_OK);
		}else {
			assertEquals(httpResponse.getStatusLine().getStatusCode(), HttpStatus.SC_BAD_REQUEST);
		}

	}

}
