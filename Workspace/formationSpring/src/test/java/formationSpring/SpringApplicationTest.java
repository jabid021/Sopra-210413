package formationSpring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import formationSpring.application.MainSpring;
import formationSpring.configuration.AppConfig;

public class SpringApplicationTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		ctx.getBeanFactory().createBean(MainSpring.class).run(args);
		ctx.close();
	}
}
