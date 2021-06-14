package formation.sopra.springBoot.services;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
public class AutreConsoleService implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		System.out.println("autre console gere par un autre service");
	}

}
