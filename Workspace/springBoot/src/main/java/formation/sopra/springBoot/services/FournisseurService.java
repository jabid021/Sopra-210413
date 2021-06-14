package formation.sopra.springBoot.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import formation.sopra.springBoot.entities.Fournisseur;
import formation.sopra.springBoot.exceptions.FournisseurException;
import formation.sopra.springBoot.repositories.FournisseurRepository;
import formation.sopra.springBoot.repositories.ProduitRepositry;

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

	public List<Fournisseur> getAll() {
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

	public Fournisseur getByContact(String contact) {
		if (contact != null) {
			Optional<Fournisseur> opt = fournisseurRepository.findByContact(contact);
			if (opt.isPresent()) {
				return opt.get();
			}
		}
		return new Fournisseur();
	}

}
