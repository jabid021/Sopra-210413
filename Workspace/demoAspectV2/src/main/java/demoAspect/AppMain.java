package demoAspect;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppMain {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		ctx.getBean("personne",InterfacePersonne.class).sePresenter();
		//ctx.getBean("autreClassAvecSePresenter",InterfacePersonne.class).sePresenter();
		
		ctx.close();
	}
}
