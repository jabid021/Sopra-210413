package demoAspect;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainAvecXml {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("application-context.xml");
		InterfacePersonne iP = ctx.getBean(Personne.class);
		iP.sePresenter();
		ctx.close();
	}
}
