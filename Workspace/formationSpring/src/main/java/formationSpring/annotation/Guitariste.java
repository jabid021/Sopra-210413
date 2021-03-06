package formationSpring.annotation;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Guitariste implements Musicien {

	@Autowired
	@Qualifier("guitare")
	private Instrument instrument;

//	public Guitariste() {
//		System.out.println(instrument);
//	}
//
//	@PostConstruct
//	public void xxxx() {
//		System.out.println(instrument);
//	}

	public Instrument getInstrument() {
		return instrument;
	}

	public void setInstrument(Instrument instrument) {
		this.instrument = instrument;
	}

	@Override
	public void jouer() {
		// throw new IllegalArgumentException("fausse note");
		System.out.println("le guitariste joue de son instrument:" + instrument);
	}

	public void solo() {
		System.out.println("un solo du gutariste");
	}

}
