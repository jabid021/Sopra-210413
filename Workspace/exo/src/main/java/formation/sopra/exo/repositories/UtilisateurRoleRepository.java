package formation.sopra.exo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import formation.sopra.exo.model.entites.UtilisateurRole;
import formation.sopra.exo.model.entites.UtilisateurRoleKey;

public interface UtilisateurRoleRepository extends JpaRepository<UtilisateurRole, UtilisateurRoleKey> {

}
