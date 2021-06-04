package exoJpaSpring.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import exoJpaSpring.config.AppConfig;
import exoJpaSpring.entity.Client;
import exoJpaSpring.exceptions.ClientException;
import exoJpaSpring.services.ClientService;

public class ClientTest {

	ClientService service;
	static AnnotationConfigApplicationContext ctx = null;

	@BeforeClass
	public static void initSpring() {
		ctx = new AnnotationConfigApplicationContext(AppConfig.class);
	}

	@AfterClass
	public static void closeSpring() {
		ctx.close();
	}

	@Before
	public void initService() {
		service = ctx.getBean(ClientService.class);
	}

	@After
	public void after() {
		// execution apres chaque test
	}

	@Test
	public void recupererClientService() {
		assertNotNull(ctx.getBean(ClientService.class));
	}

	@Test
	public void creationClient() throws ClientException {
		Client c = new Client();
		c.setNom("client");
		c = service.save(c);
		assertNotNull(service.getById(c.getId()));
	}

	@Test(expected = ClientException.class)
	public void nomNonFournis() throws ClientException {
		Client c = new Client();
		c = service.save(c);
	}

	@Test
	public void deleteClient() throws ClientException {
		Client c = new Client();
		c.setNom("client");
		c = service.save(c);
		service.delete(c);
		assertEquals(new Client(), service.getById(c.getId()));

	}
}
