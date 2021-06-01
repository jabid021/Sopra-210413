package formationSpring.application;

import org.springframework.beans.factory.annotation.Autowired;

import formationSpring.annotation.Musicien;

public class MainSpring {

	@Autowired
	private Musicien musicien;

	public void run(String[] args) {
		// point d'entree
		musicien.jouer();
	}
}
