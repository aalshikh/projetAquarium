package projet.devops.aquarium;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.junit.Assert;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import projet.devops.aquarium.model.Animal;

import java.net.URI;
import java.net.URISyntaxException;


@RunWith(SpringRunner.class)
@SpringBootTest
class AquariumApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	public void testAnimal1MissingHeader() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();
		final String baseUrl = "http://localhost:8080/Animals/d";
		URI uri = new URI(baseUrl);
		HttpHeaders headers = new HttpHeaders();
		headers.set("X-COM-LOCATION", "USA");
		HttpEntity<Animal> requestEntity = new HttpEntity<>(null, headers);
		try {
			restTemplate.exchange(uri, HttpMethod.GET, requestEntity, String.class);
			Assert.fail();
		} catch (HttpClientErrorException ex) {
			//Verify bad request and missing header
			Assert.assertEquals(400,403, ex.getRawStatusCode());
			Assert.assertEquals(false, ex.getResponseBodyAsString().contains("Missing request header"));
		}
	}
		@Test
		public void testAnimal2MissingHeader() throws URISyntaxException
		{
			RestTemplate restTemplate = new RestTemplate();
			final String baseUrl = "http://localhost:8080/Animal";
			URI uri = new URI(baseUrl);
			HttpHeaders headers = new HttpHeaders();
			headers.set("X-COM-LOCATION", "USA");
			HttpEntity<Animal> requestEntity = new HttpEntity<>(null, headers);
			try
			{
				restTemplate.exchange(uri, HttpMethod.GET, requestEntity, String.class);
				Assert.fail();
			}
			catch(HttpClientErrorException ex)
			{
				//Verify bad request and missing header
				Assert.assertEquals(404,403, ex.getRawStatusCode());
				Assert.assertEquals(false, ex.getResponseBodyAsString().contains("Missing request header"));
			}
		}

	@Test
	public void testAnimal3MissingHeader() throws URISyntaxException
	{
		RestTemplate restTemplate = new RestTemplate();
		final String baseUrl = "http://localhost:8080/Animals";
		URI uri = new URI(baseUrl);
		//Animal animal = new Animal(1, 12, "En forme" , "2018-01-09", "2021-01-09", "Requin", "Marto", "M", "cicatrice a la tete", 2.0, null);
		HttpHeaders headers = new HttpHeaders();
		headers.set("X-COM-LOCATION", "USA");
		HttpEntity<Animal> requestEntity = new HttpEntity<>(null, headers);
		try
		{
			restTemplate.exchange(uri, HttpMethod.POST, requestEntity, String.class);
			Assert.fail();
		}
		catch(HttpClientErrorException ex)
		{
			//Verify bad request and missing header
			Assert.assertEquals(415,403, ex.getRawStatusCode());
			Assert.assertEquals(false, ex.getResponseBodyAsString().contains("Missing request header"));
		}
	}

	@Test
	public void testAnimal4MissingHeader() throws URISyntaxException
	{
		RestTemplate restTemplate = new RestTemplate();
		final String baseUrl = "http://localhost:8080/Animals";
		URI uri = new URI(baseUrl);
		//Animal animal = new Animal(1, 12, "En forme" , "2018-01-09", "2021-01-09", "Requin", "Marto", "M", "cicatrice a la tete", 2.0, null);
		HttpHeaders headers = new HttpHeaders();
		headers.set("X-COM-LOCATION", "USA");
		HttpEntity<Animal> requestEntity = new HttpEntity<>(null, headers);
		try
		{
			restTemplate.exchange(uri, HttpMethod.DELETE, requestEntity, String.class);
			Assert.fail();
		}
		catch(HttpClientErrorException ex)
		{
			//Verify bad request and missing header
			Assert.assertEquals(405,403, ex.getRawStatusCode());
			Assert.assertEquals(false, ex.getResponseBodyAsString().contains("Missing request header"));
		}
	}

	@Test
	public void testAnimal5MissingHeader() throws URISyntaxException
	{
		RestTemplate restTemplate = new RestTemplate();
		final String baseUrl = "http://localhost:8080/Animals";
		URI uri = new URI(baseUrl);
		//Animal animal = new Animal(1, 12, "En forme" , "2018-01-09", "2021-01-09", "Requin", "Marto", "M", "cicatrice a la tete", 2.0, null);
		HttpHeaders headers = new HttpHeaders();
		headers.set("X-COM-LOCATION", "USA");
		HttpEntity<Animal> requestEntity = new HttpEntity<>(null, headers);
		try
		{
			restTemplate.exchange(uri, HttpMethod.PUT, requestEntity, String.class);
			Assert.fail();
		}
		catch(HttpClientErrorException ex)
		{
			//Verify bad request and missing header
			Assert.assertEquals(405,403, ex.getRawStatusCode());
			Assert.assertEquals(false, ex.getResponseBodyAsString().contains("Missing request header"));
		}
	}

	@Test
	public void testAnimal6MissingHeader() throws URISyntaxException
	{
		RestTemplate restTemplate = new RestTemplate();
		final String baseUrl = "http://localhost:8080/Animals/1000";
		URI uri = new URI(baseUrl);
		//Animal animal = new Animal(1, 12, "En forme" , "2018-01-09", "2021-01-09", "Requin", "Marto", "M", "cicatrice a la tete", 2.0, null);
		HttpHeaders headers = new HttpHeaders();
		headers.set("X-COM-LOCATION", "USA");
		HttpEntity<Animal> requestEntity = new HttpEntity<>(null, headers);
		try
		{
			restTemplate.exchange(uri, HttpMethod.POST, requestEntity, String.class);
			Assert.fail();
		}
		catch(HttpClientErrorException ex)
		{
			//Verify bad request and missing header
			Assert.assertEquals(405, 403, ex.getRawStatusCode());
			Assert.assertEquals(false, ex.getResponseBodyAsString().contains("Missing request header"));
		}
	}

}
