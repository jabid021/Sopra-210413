package formationSpring.annotation;

import org.springframework.stereotype.Component;

@Component
public class Saxophone implements Instrument {
	@Override
	public String toString() {
		return "saxophone";
	}
}
