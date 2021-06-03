package exoJpaSpring.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import exoJpaSpring.config.AppConfig;

public class App {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		ctx.getBeanFactory().createBean(exoJpaSpring.AppSpring.class).run(args);
		ctx.close();
	}

}
