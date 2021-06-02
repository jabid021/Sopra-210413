package demoAspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MonAspect {
	
//	@Autowired
//	private UnAutreBean bean;

	@Pointcut("execution(* demoAspect.*.sePresenter())")
	public void pointcut() {

	}

	@Before("pointcut()")
	public void before(JoinPoint joinPoint) {
		before1(joinPoint);
		before2();
	}

	private void before1(JoinPoint joinPoint) {
		if (joinPoint.getTarget() instanceof Personne) {
			System.out.println("c'est une personne");
		}
		System.out.println("before");
	}

	private void before2() {
		System.out.println("before2");
	}

	@After("pointcut()")
	public void after() {
		System.out.println("after");
	}

	@AfterReturning(pointcut = "pointcut()", returning = "retour")
	public void afterReturning(String retour) {
		System.out.println("after returning, valeur recu:" + retour);
	}

	@AfterThrowing(pointcut = "pointcut()")
	public void afterThrowing() {
		System.out.println("afterThrowing");
	}

	@Around("pointcut()")
	public void around(ProceedingJoinPoint pJP) throws Throwable {
		// code avant l'execution du pointcut()
		System.out.println("arround avant execution");
		if (pJP.getTarget() instanceof Personne) {
			// execution la methode du pointcut()
			pJP.proceed();
		}
		// code apres l'execution du pointcut()
		System.out.println("arround apres execution");

	}
}
