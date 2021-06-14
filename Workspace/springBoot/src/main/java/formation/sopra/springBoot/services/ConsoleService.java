package formation.sopra.springBoot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import formation.sopra.springBoot.entities.Role;
import formation.sopra.springBoot.entities.Utilisateur;
import formation.sopra.springBoot.repositories.UtilisateurRepository;

@Service
public class ConsoleService implements CommandLineRunner {

	@Autowired
	private UtilisateurRepository utilisateurRepo;
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public void run(String... args) throws Exception {
		//initUtilisateur();
	}

	private void initUtilisateur() {
		Utilisateur admin = new Utilisateur();
		admin.setLogin("admin");
		admin.setPassword(passwordEncoder.encode("admin123"));
		admin.setRole(Role.ROLE_ADMIN);
		utilisateurRepo.save(admin);
		Utilisateur user = new Utilisateur();
		user.setLogin("user");
		user.setPassword(passwordEncoder.encode("user123"));
		user.setRole(Role.ROLE_USER);
		utilisateurRepo.save(user);

	}

}
