package formation.sopra.springBoot.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import formation.sopra.springBoot.entities.Client;
import formation.sopra.springBoot.entities.Commande;
import formation.sopra.springBoot.exceptions.ClientException;
import formation.sopra.springBoot.exceptions.CommandeException;
import formation.sopra.springBoot.repositories.CommandeRepository;
import formation.sopra.springBoot.repositories.LigneCommandeRepository;

@Service
public class CommandeService {
	@Autowired
	private CommandeRepository commandeRepository;
	@Autowired
	private ClientService clientService;
	@Autowired
	private LigneCommandeRepository ligneCommandeRepository;

	public Commande save(Commande commande) throws CommandeException, ClientException {
		if (commande.getDate() == null) {
			throw new CommandeException("date obligatoire");
		}
		if (commande.getClient() != null) {
			if (commande.getClient().getId() == null) {
				clientService.save(commande.getClient());
			}
		}
		commandeRepository.save(commande);
		// commande.getLignesCommandes().stream().forEach(lc->{ligneCommandeRepository.save(lc);});
		if (commande.getLignesCommandes() != null) {
			commande.getLignesCommandes().stream().forEach(ligneCommandeRepository::save);
		}
		return commande;
	}

	public void delete(Commande commande) {
		delete(commande.getNumero());
	}

	public void delete(Client client) {
		commandeRepository.findByClient(client).stream().forEach(commande -> {
			delete(commande);
		});
	}

	public void delete(Integer id) {
		if (id != null) {
			Optional<Commande> opt = commandeRepository.findById(id);
			if (opt.isPresent()) {
				ligneCommandeRepository.deleteByCommande(opt.get());
				commandeRepository.delete(opt.get());
			}
		}
	}

	public List<Commande> getAll() {
		return commandeRepository.findAllWithLigneCommande();
	}

	public Commande getById(Integer id) throws CommandeException {
		if (id != null) {
			Optional<Commande> opt = commandeRepository.findByIdWithLigneCommande(id);
			if (opt.isPresent()) {
				return opt.get();
			}
		}
		throw new CommandeException("commande introuvable");
	}

}
