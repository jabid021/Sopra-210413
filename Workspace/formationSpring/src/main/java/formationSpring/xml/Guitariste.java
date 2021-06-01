package formationSpring.xml;

public class Guitariste implements Musicien {

	private Instrument instrument;

	public Guitariste() {
	}

	public Instrument getInstrument() {
		return instrument;
	}

	public void setInstrument(Instrument instrument) {
		this.instrument = instrument;
	}

	@Override
	public void jouer() {
		System.out.println("le guitariste joue de son instrument:" + instrument);
	}

}
