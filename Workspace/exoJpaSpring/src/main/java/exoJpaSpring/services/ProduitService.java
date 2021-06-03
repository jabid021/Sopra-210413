package exoJpaSpring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import exoJpaSpring.entity.Produit;
import exoJpaSpring.exceptions.ProduitException;
import exoJpaSpring.repositories.ProduitRepositry;

@Service
public class ProduitService {
	@Autowired
	private ProduitRepositry produitRepository;

	public Produit save(Produit produit) throws ProduitException {
		if (produit.getNom() == null || produit.getNom().isEmpty()) {
			throw new ProduitException("données incorrectes:le nom doit etre renseigné");
		}
		if (produit.getPrix() <= 0) {
			throw new ProduitException("données incorrectes:le prix doit etre superieur à 0");
		}
		return produitRepository.save(produit);
	}

	public void delete(Integer id) {
		if (id != null) {
			produitRepository.deleteById(id);
		}
	}

	public void deleteFournisseurNull() {
		produitRepository.deleteProduitSansFournisseur();
	}

	public List<Produit> getAllProduits() {
		return produitRepository.findAll();
	}

	public Produit getById(Integer id) throws ProduitException {
		if (id != null) {
			Optional<Produit> opt = produitRepository.findById(id);
			if (opt.isPresent()) {
				return opt.get();
			}
		}
		throw new ProduitException("produit introuvable");
		// return new Produit();
	}

}
