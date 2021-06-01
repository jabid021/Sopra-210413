package formationSpring.annotation;

public class Pianiste implements Musicien {
	private Instrument instrument;

	public Instrument getInstrument() {
		return instrument;
	}

	public void setInstrument(Instrument instrument) {
		this.instrument = instrument;
	}

	@Override
	public void jouer() {
		System.out.println("le pianiste joue:" + instrument);
	}

}
