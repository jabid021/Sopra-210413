package exoJpaSpring.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import exoJpaSpring.entity.Client;
import exoJpaSpring.entity.Commande;

public interface CommandeRepository extends JpaRepository<Commande, Integer> {
	@Query("delete from Commande c where c.client=:client")
	@Modifying
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	int deleteByClient(@Param("client") Client client);

	@Query("select c from Commande c left join fetch c.lignesCommandes where c.numero=:id")
	Optional<Commande> findByIdWithLigneCommande(@Param("id") Integer id);

	@Query("select c from Commande c left join fetch c.lignesCommandes")
	List<Commande> findAllWithLigneCommande();

	List<Commande> findByClient(Client client);

}
