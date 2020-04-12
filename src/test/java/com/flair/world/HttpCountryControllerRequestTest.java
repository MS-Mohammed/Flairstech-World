package com.flair.world;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;

import com.flair.world.model.Country;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class HttpCountryControllerRequestTest {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void invaildCountryCodeShouldReturnMessage_InternalServerError() throws Exception {
		assertThat(this.restTemplate.getForEntity("http://localhost:" + port + "/1", 
				Country.class).getStatusCode()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR);
		
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/1",
				String.class)).contains("INVALID_COUNTRY_CODE");
	}

}
