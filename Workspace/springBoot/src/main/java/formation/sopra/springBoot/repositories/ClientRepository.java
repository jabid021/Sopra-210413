package formation.sopra.springBoot.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import formation.sopra.springBoot.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Integer> {
	@Query("select c from Client c left join fetch c.commandes where c.id=:id")
	Optional<Client> findByIdWithCommandes(@Param("id") Integer id);
}
