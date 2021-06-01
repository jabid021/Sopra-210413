package formationSpring.annotation;

public class Saxophoniste implements Musicien {

	private Instrument instrument;

	public Instrument getInstrument() {
		return instrument;
	}

	public void setInstrument(Instrument instrument) {
		this.instrument = instrument;
	}

	@Override
	public void jouer() {
		System.out.println("le saxophoniste joue:" + instrument);

	}

}
