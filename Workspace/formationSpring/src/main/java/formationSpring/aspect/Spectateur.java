package formationSpring.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import formationSpring.annotation.Musicien;

//@Component
//@Aspect
public class Spectateur {

	@Autowired
	@Qualifier("saxophoniste")
	private Musicien saxophoniste;

	@Pointcut("execution(* formationSpring.annotation.Musicien.jouer())")
	public void jouer() {

	}

	@Pointcut("execution(* formationSpring.annotation.Guitariste.jouer())")
	public void jouerGuitariste() {

	}

	@Pointcut("execution(* formationSpring.annotation.Saxophoniste.jouer())")
	public void jouerSaxophoniste() {

	}

	@Before("jouerGuitariste()")
	public void before() {
		sintaller();
		coupertelephone();
	}

	private void sintaller() {
		System.out.println("les spectateurs s'installent");
	}

	private void coupertelephone() {
		System.out.println("les spectateurs coupent leurs telephones");
	}

	@AfterThrowing("jouer()")
	public void pasContent() {
		System.out.println("rembourser");
	}

	@AfterReturning(pointcut = "jouer()")
	public void content() {
		System.out.println("bravo!!!!");
	}

	@After("jouerGuitariste()")
	public void finGuitariste() {
		saxophoniste.jouer();
	}

	@After("jouerSaxophoniste()")
	public void fin() {
		allumerTelephone();
		partir();
	}

	private void allumerTelephone() {
		System.out.println("les spectateurs allument leurs telephones");
	}

	private void partir() {
		System.out.println("les spectateurs partent");
	}
}
