package formationSpring.configuration;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import formationSpring.annotation.Instrument;
import formationSpring.annotation.Pianiste;
import formationSpring.annotation.Synthe;

@Configuration
@ComponentScan("formationSpring.annotation")
public class ExoConfig {

	@Bean
	public Instrument synthe() {
		return new Synthe();
	}

	@Bean
	public Pianiste pianiste(@Qualifier("synthe") Instrument instrument) {
		Pianiste pianiste = new Pianiste();
		pianiste.setInstrument(instrument);
		return pianiste;
	}

}
