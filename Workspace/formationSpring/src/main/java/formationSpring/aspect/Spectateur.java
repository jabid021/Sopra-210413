package formationSpring.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Spectateur {

	@Pointcut("execution(* formationSpring.annotation.Musicien.jouer())")
	public void jouer() {

	}

	@Before("jouer()")
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

	@After("jouer()")
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
