package formationSpring.application;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import formationSpring.annotation.Musicien;

public class ExoMainspring {

	@Autowired
	@Qualifier("guitariste")
	private Musicien guitariste;
	@Autowired
	@Qualifier("pianiste")
	private Musicien pianiste;

	public void run(String[] args) {
		Scanner sc = new Scanner(System.in);
		String lu = sc.nextLine();
		if (lu.equals("guitariste")) {
			guitariste.jouer();
		} else {
			pianiste.jouer();
		}
		sc.close();
	}
}
