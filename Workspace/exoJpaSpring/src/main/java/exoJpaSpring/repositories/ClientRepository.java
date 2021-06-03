package exoJpaSpring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import exoJpaSpring.entity.Client;

public interface ClientRepository extends JpaRepository<Client, Integer> {

}
