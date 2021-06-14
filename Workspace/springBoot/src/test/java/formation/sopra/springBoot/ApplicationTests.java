package formation.sopra.springBoot;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import formation.sopra.springBoot.entities.Fournisseur;
import formation.sopra.springBoot.exceptions.FournisseurException;
import formation.sopra.springBoot.services.FournisseurService;

@SpringBootTest
class ApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private FournisseurService fournisseurService;

	@Test
	public void getService() {
		assertNotNull(fournisseurService);
	}

	@Test
	public void testInsert() throws FournisseurException {
		Fournisseur f = new Fournisseur();
		f.setNom("frs");
		fournisseurService.save(f);
	}
}
