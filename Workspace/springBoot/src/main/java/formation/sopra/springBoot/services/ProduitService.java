package formation.sopra.springBoot.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import formation.sopra.springBoot.entities.Produit;
import formation.sopra.springBoot.exceptions.FournisseurException;
import formation.sopra.springBoot.exceptions.ProduitException;
import formation.sopra.springBoot.repositories.ProduitRepositry;

@Service
public class ProduitService {
	@Autowired
	private ProduitRepositry produitRepository;
	@Autowired
	private FournisseurService fournisseurService;
	@Autowired
	private CommandeService commandeService;

	public Produit save(Produit produit) throws ProduitException, FournisseurException {
		if (produit.getNom() == null || produit.getNom().isEmpty()) {
			throw new ProduitException("données incorrectes:le nom doit etre renseigné");
		}
		if (produit.getPrix() <= 0) {
			throw new ProduitException("données incorrectes:le prix doit etre superieur à 0");
		}
		if (produit.getFournisseur() != null) {
			if (produit.getFournisseur().getId() == null) {
				fournisseurService.save(produit.getFournisseur());
			}
		}
		return produitRepository.save(produit);
	}

	public void delete(Integer id) {
		if (id != null) {
			Optional<Produit> opt = produitRepository.findByIdWithLigneCommande(id);
			if (opt.isPresent()) {
				Produit p = opt.get();
				p.getLignesCommandes().stream().forEach(lc -> {
					commandeService.delete(lc.getKey().getCommande());
				});
				produitRepository.deleteById(p.getId());
			}

		}
	}

	public void deleteFournisseurNull() {
		produitRepository.deleteProduitSansFournisseur();
	}

	public List<Produit> getAll() {
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
