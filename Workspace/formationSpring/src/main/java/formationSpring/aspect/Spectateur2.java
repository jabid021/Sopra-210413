package formationSpring.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import formationSpring.annotation.Guitariste;
import formationSpring.annotation.Musicien;
import formationSpring.annotation.Saxophoniste;

@Component
@Aspect
public class Spectateur2 {

	@Autowired
	@Qualifier("saxophoniste")
	private Musicien saxophoniste;

	@Pointcut("execution(* formationSpring.annotation.Musicien.jouer())")
	public void jouer() {
	}

	@Around("jouer()")
	public void around(ProceedingJoinPoint pJP) throws Throwable {
		if (pJP.getTarget() instanceof Guitariste) {
			// guitariste
			before();
			try {
				pJP.proceed();
				((Guitariste) pJP.getTarget()).solo();
			} finally {
				saxophoniste.jouer();
			}
		} else if (pJP.getTarget() instanceof Saxophoniste) {
			// saxophoniste
			try {
				pJP.proceed();
			} finally {
				fin();
			}
		}
	}

	public void before() {
		sintaller();
		coupertelephone();
	}

	private void sintaller() {
		System.out.println("les spectateursssssss s'installent");
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
