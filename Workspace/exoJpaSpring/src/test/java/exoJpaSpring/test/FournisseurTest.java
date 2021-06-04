package exoJpaSpring.test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import exoJpaSpring.config.AppConfig;
import exoJpaSpring.services.FournisseurService;

import static org.junit.Assert.*;

import org.junit.Test;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class FournisseurTest {
	@Autowired
	private FournisseurService fournisseurService;

	@Test
	public void getService() {
		assertNotNull(fournisseurService);
	}
}
