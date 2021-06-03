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
	private CommandeRepository commandeRepository;

	public Client save(Client client) throws ClientException {
		if (client.getNom() == null || client.getNom().isEmpty()) {
			throw new ClientException("nom obligatoire");
		}
		return clientRepository.save(client);
	}

	public void delete(Client client) {
		if (client != null) {
			commandeRepository.deleteByClient(client);
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

	public List<Client> getAllClient() {
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

}
