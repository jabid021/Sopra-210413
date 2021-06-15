package formation.sopra.exo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import formation.sopra.exo.model.CustomUserDetails;
import formation.sopra.exo.model.entites.Utilisateur;
import formation.sopra.exo.repositories.UtilisateurRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UtilisateurRepository utilisateurRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Utilisateur> opt = utilisateurRepo.findByLoginWithRoles(username);
		if (opt.isPresent()) {
			return new CustomUserDetails(opt.get());
		}
		throw new UsernameNotFoundException("user not found");
	}

}
