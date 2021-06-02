package demoAspect;

import org.springframework.stereotype.Component;

@Component
public class AutreClassAvecSePresenter implements InterfacePersonne {

	@Override
	public String sePresenter() {
		System.out.println("se presenter de AutreClassAvecSePresenter");
		return "AutreClassAvecSePresenter";
	}

}
