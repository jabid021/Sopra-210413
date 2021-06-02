package formationSpring.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.ImportResource;

import formationSpring.annotation.Instrument;
import formationSpring.xml.Formation;
import formationSpring.annotation.Guitare;
import formationSpring.xml.Stagiaire;

@Configuration
@ComponentScan({ "formationSpring.annotation", "formationSpring.aspect" })
@EnableAspectJAutoProxy
//@ImportResource("classpath:application-context.xml")
public class AppConfig {

	@Bean("bean")
	public Instrument guitare() {
		return new Guitare();
	}

	@Bean
	public Formation formation() {
		Formation f = new Formation();
		f.setNom("java");
		return f;
	}

	@Bean
	public Stagiaire stagiaire(Formation formation) {
		Stagiaire stagiaire = new Stagiaire();
		stagiaire.setFormation(formation);
		stagiaire.setPrenom("olivier");
		return stagiaire;
	}
}
