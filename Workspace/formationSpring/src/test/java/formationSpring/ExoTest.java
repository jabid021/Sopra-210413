package formationSpring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import formationSpring.application.ExoMainspring;
import formationSpring.configuration.ExoConfig;

public class ExoTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ExoConfig.class);
		ctx.getBeanFactory().createBean(ExoMainspring.class).run(args);
		ctx.close();
	}
}
