package formation.sopra.springBoot.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import formation.sopra.springBoot.entities.Client;
import formation.sopra.springBoot.entities.Role;
import formation.sopra.springBoot.exceptions.ClientException;
import formation.sopra.springBoot.repositories.ClientRepository;
import formation.sopra.springBoot.repositories.UtilisateurRepository;

@Service
public class ClientService {
	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private CommandeService commandeService;
	@Autowired
	private UtilisateurRepository utilisateurRepository;


	public Client save(Client client) throws ClientException {
		if (client.getNom() == null || client.getNom().isEmpty()) {
			throw new ClientException("nom obligatoire");
		}
		if (client.getUtilisateur() == null) {
			throw new ClientException("pas d'utilisateur pour ce client");
		}
		client.getUtilisateur().setRole(Role.ROLE_USER);
		utilisateurRepository.save(client.getUtilisateur());
		return clientRepository.save(client);
	}

	public void delete(Client client) {
		if (client != null) {
			commandeService.delete(client);
			clientRepository.delete(client);
		}
	}

	public void delete(Integer id) {
		if (id != null) {
			Optional<Client> opt = clientRepository.findById(id);
			if (opt.isPresent()) {
				delete(opt.get());
			}
		}
	}

	public List<Client> getAll() {
		return clientRepository.findAll();
	}

	public Client getById(Integer id) {
		if (id != null) {
			Optional<Client> opt = clientRepository.findById(id);
			if (opt.isPresent()) {
				return opt.get();
			}
		}
		return new Client();

	}

	public Client getByIdWithCommandes(Integer id) {
		if (id != null) {
			Optional<Client> opt = clientRepository.findByIdWithCommandes(id);
			if (opt.isPresent()) {
				return opt.get();
			}
		}
		return new Client();
	}

}
