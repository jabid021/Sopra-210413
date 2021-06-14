package formation.sopra.springBoot.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import formation.sopra.springBoot.config.UtilisateurSpring;
import formation.sopra.springBoot.entities.Utilisateur;
import formation.sopra.springBoot.repositories.UtilisateurRepository;

@Service
public class AuthService implements UserDetailsService {

	@Autowired
	private UtilisateurRepository utilisateurRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Utilisateur> opt = utilisateurRepo.findByLogin(username);
		if (opt.isPresent()) {
			return new UtilisateurSpring(opt.get());
		}
		throw new UsernameNotFoundException("utilisateur introuvable");
	}

}
