package formationSpring.annotation;

import org.springframework.stereotype.Component;

@Component("fender")
public class Guitare implements Instrument {
	@Override
	public String toString() {
		return "guitare";
	}
}
