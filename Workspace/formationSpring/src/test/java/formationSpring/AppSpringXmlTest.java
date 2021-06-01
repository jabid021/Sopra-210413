package formationSpring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import formationSpring.annotation.Musicien;

public class AppSpringXmlTest {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:application-context.xml");
		// Stagiaire stagiaire = ctx.getBean(Stagiaire.class); ne fonctionne pas car 2
		// stagiaires de disponible
//		Stagiaire stagiaire = ctx.getBean("stagiaire", Stagiaire.class);
//		stagiaire.methodeStagiaire();
//		System.out.println(stagiaire.getFormation());
//		System.out.println(ctx.getBean("java"));
//
//		stagiaire = ctx.getBean("s3AvecSaFormationALui", Stagiaire.class);
//		System.out.println(stagiaire.getFormation());

		Musicien unMusicien = ctx.getBean(Musicien.class);
		unMusicien.jouer();
		ctx.close();
	}
}
