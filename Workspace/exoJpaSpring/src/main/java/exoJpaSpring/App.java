package exoJpaSpring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import exoJpaSpring.config.AppConfig;

public class App {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		ctx.getBeanFactory().createBean(AppSpring.class).run(args);
		ctx.close();
	}

}
