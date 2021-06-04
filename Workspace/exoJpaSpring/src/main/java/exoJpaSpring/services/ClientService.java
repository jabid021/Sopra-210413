package exoJpaSpring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import exoJpaSpring.entity.Client;
import exoJpaSpring.exceptions.ClientException;
import exoJpaSpring.repositories.ClientRepository;
import exoJpaSpring.repositories.CommandeRepository;

@Service
public class ClientService {
	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private CommandeService commandeService;

	public Client save(Client client) throws ClientException {
		if (client.getNom() == null || client.getNom().isEmpty()) {
			throw new ClientException("nom obligatoire");
		}
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
