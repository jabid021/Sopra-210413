package demoAspect;

import org.springframework.stereotype.Component;

@Component
public class Personne implements InterfacePersonne {

	@Override
	public String sePresenter() {
		// throw new IllegalArgumentException("probleme");
		System.out.println("methode se presenter de Personne");
		return "personne";
	}

}
