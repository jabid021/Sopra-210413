package formation.sopra.springBoot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import formation.sopra.springBoot.entities.Commande;
import formation.sopra.springBoot.entities.LigneCommande;
import formation.sopra.springBoot.entities.LigneCommandeKey;

public interface LigneCommandeRepository extends JpaRepository<LigneCommande, LigneCommandeKey> {
	@Query("delete from LigneCommande lc  where key.commande=:commande")
	@Modifying
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	int deleteByCommande(@Param("commande") Commande commande);
}
