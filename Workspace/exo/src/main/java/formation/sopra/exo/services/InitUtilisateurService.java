package formation.sopra.exo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import formation.sopra.exo.model.Role;
import formation.sopra.exo.model.entites.Utilisateur;
import formation.sopra.exo.model.entites.UtilisateurRole;
import formation.sopra.exo.model.entites.UtilisateurRoleKey;
import formation.sopra.exo.repositories.UtilisateurRepository;
import formation.sopra.exo.repositories.UtilisateurRoleRepository;

//@Service
public class InitUtilisateurService implements CommandLineRunner {

	@Autowired
	private UtilisateurRepository uR;
	@Autowired
	private UtilisateurRoleRepository uRR;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public void run(String... args) throws Exception {
		Utilisateur admin = new Utilisateur("admin", passwordEncoder.encode("admin"));
		Utilisateur rh = new Utilisateur("rh", passwordEncoder.encode("rh"));
		Utilisateur multi = new Utilisateur("multi", passwordEncoder.encode("multi"));
		uR.save(admin);
		uR.save(rh);
		uR.save(multi);

		UtilisateurRole role = new UtilisateurRole(new UtilisateurRoleKey(admin, Role.ROLE_ADMIN));
		uRR.save(role);
		role = new UtilisateurRole(new UtilisateurRoleKey(rh, Role.ROLE_RH));
		uRR.save(role);
		role = new UtilisateurRole(new UtilisateurRoleKey(multi, Role.ROLE_ADMIN));
		uRR.save(role);
		role = new UtilisateurRole(new UtilisateurRoleKey(multi, Role.ROLE_RH));
		uRR.save(role);
		role = new UtilisateurRole(new UtilisateurRoleKey(multi, Role.ROLE_INFO));
		uRR.save(role);
	}

}
