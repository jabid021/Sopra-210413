package formationSpring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import formationSpring.annotation.Guitare;
import formationSpring.annotation.Musicien;
import formationSpring.configuration.AppConfig;
import formationSpring.xml.Formation;
import formationSpring.xml.Stagiaire;

public class AppSpringAnnotationTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		Musicien gutariste = ctx.getBean("guitariste", Musicien.class);
		gutariste.jouer();

		ctx.close();
	}
}
