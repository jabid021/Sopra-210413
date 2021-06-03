package exoJpaSpring.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import exoJpaSpring.entity.Produit;

public interface ProduitRepositry extends JpaRepository<Produit, Integer> {
	List<Produit> findByNom(String nom);

	List<Produit> findByNomLike(String nom);

	List<Produit> findByNomContaining(String nom);

	List<Produit> findByNomContainingAndPrixLessThan(String no, double prix);

	List<Produit> findByFournisseurIsNull();

	List<Produit> findByFournisseurIsNotNull();
}
