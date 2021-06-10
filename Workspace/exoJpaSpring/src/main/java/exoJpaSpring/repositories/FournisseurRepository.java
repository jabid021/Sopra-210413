package exoJpaSpring.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import exoJpaSpring.entity.Fournisseur;

public interface FournisseurRepository extends JpaRepository<Fournisseur, Integer> {
	@Query("select frs from Fournisseur frs left join fetch frs.produits where frs.id=:toto")
	Optional<Fournisseur> findByIdWithProduits(@Param("toto") Integer id);

	Optional<Fournisseur> findByContact(String contact);
}
