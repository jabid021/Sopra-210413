package exoJpaSpring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import exoJpaSpring.entity.Client;
import exoJpaSpring.entity.Fournisseur;
import exoJpaSpring.exceptions.ClientException;
import exoJpaSpring.exceptions.FournisseurException;
import exoJpaSpring.repositories.FournisseurRepository;
import exoJpaSpring.repositories.ProduitRepositry;

@Service
public class FournisseurService {
	@Autowired
	private FournisseurRepository fournisseurRepository;
	@Autowired
	private ProduitRepositry produitRepository;

	public Fournisseur save(Fournisseur fournisseur) throws FournisseurException {
		if (fournisseur.getNom() == null || fournisseur.getNom().isEmpty()) {
			throw new FournisseurException("nom obligatoire");
		}
		return fournisseurRepository.save(fournisseur);
	}

	public void delete(Fournisseur fournisseur) {
		if (fournisseur != null) {
			produitRepository.setFournisseurNull(fournisseur);
			fournisseurRepository.delete(fournisseur);
		}
	}

	public void delete(Integer id) {
		if (id != null) {
			Optional<Fournisseur> opt = fournisseurRepository.findById(id);
			if (opt.isPresent()) {
				delete(opt.get());
			}
		}
	}

	public List<Fournisseur> getAllClient() {
		return fournisseurRepository.findAll();
	}

	public Fournisseur getById(Integer id) {
		if (id != null) {
			Optional<Fournisseur> opt = fournisseurRepository.findById(id);
			if (opt.isPresent()) {
				return opt.get();
			}
		}
		return new Fournisseur();

	}

}
