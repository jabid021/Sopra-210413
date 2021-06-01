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
		Musicien musicien = ctx.getBean(Musicien.class);
		musicien.jouer();
		ctx.getBean("fender",Guitare.class);
		System.out.println(ctx.getBean(Formation.class));
		System.out.println(ctx.getBean(Stagiaire.class).getFormation());
		ctx.close();
	}
}
