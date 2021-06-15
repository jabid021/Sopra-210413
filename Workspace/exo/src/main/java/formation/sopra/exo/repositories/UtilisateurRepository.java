package formation.sopra.exo.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import formation.sopra.exo.model.entites.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, String> {
	@Query("select u from Utilisateur u left join fetch u.roles where u.login=:login")
	Optional<Utilisateur> findByLoginWithRoles(String login);
}
