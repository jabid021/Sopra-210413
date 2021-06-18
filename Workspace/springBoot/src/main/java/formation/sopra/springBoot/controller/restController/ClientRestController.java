package formation.sopra.springBoot.controller.restController;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.ReflectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonView;

import formation.sopra.springBoot.entities.Client;
import formation.sopra.springBoot.entities.Utilisateur;
import formation.sopra.springBoot.entities.views.Views;
import formation.sopra.springBoot.exceptions.ClientException;
import formation.sopra.springBoot.exceptions.rest.ClientInvalidException;
import formation.sopra.springBoot.services.ClientService;

@RestController
@RequestMapping("/api/client")
public class ClientRestController {

	@Autowired
	private ClientService clientService;
	@Autowired
	private PasswordEncoder passwordEncoder;

	@GetMapping("")
	@JsonView(Views.Common.class)
	public List<Client> getAllClient() {
		return getAll();
	}

	@GetMapping("/commande")
	@JsonView(Views.ClientWithCommande.class)
	public List<Client> getAllClientWithCommande() {
		return getAll();
	}

	private List<Client> getAll() {
		return clientService.getAll();
	}

	@GetMapping("/{id}")
	@JsonView(Views.Common.class)
	public Client getClientById(@PathVariable Integer id) {
		return getById(id);
	}

	@GetMapping("/{id}/commande")
	@JsonView(Views.ClientWithCommande.class)
	public Client getClientWithCommandeById(Integer id) {
		return getById(id);
	}

	private Client getById(Integer id) {
		Client client = clientService.getById(id);
		if (client.getId() == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		return client;
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Integer id) {
		clientService.delete(id);
	}

	@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED)
	@JsonView(Views.Common.class)
	public Client create(@RequestBody @Valid Client client, BindingResult br) {
		if (br.hasErrors()) {
			throw new ClientInvalidException();
		}
		try {
			client.getUtilisateur().setPassword(passwordEncoder.encode(client.getUtilisateur().getPassword()));
			client = clientService.save(client);
		} catch (ClientException e) {
			throw new ClientInvalidException();
		}
		return client;
	}

	@PutMapping("/{id}")
	@JsonView(Views.Common.class)
	public Client update(@RequestBody @Valid Client client, BindingResult br, @PathVariable Integer id) {
		if (br.hasErrors()) {
			throw new ClientInvalidException();
		}
		client.setId(id);
		if (!client.getUtilisateur().getPassword().isEmpty()) {
			client.getUtilisateur().setPassword(passwordEncoder.encode(client.getUtilisateur().getPassword()));
		}
		try {
			client = clientService.save(client);
		} catch (ClientException e) {
			throw new ClientInvalidException();
		}
		return client;
	}

	@PatchMapping("/{id}")
	@JsonView(Views.Common.class)
	public Client update(@RequestBody Map<String, Object> fields, @PathVariable Integer id) {
		final Client clientEnBase = clientService.getById(id);
		Client client = null;
		if (clientEnBase.getId() == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

		if (fields.containsKey("utilisateur")) {
			throw new ClientInvalidException();
		}
		fields.forEach((key, value) -> {
//			if (key.equals("utilisateur")) {
//				((Map<String, Object>) value).forEach((k, v) -> {
//					Field fieldUtilisateur = ReflectionUtils.findField(Utilisateur.class, k);
//					ReflectionUtils.makeAccessible(fieldUtilisateur);
//					if (k.equals("password")) {
//						v = passwordEncoder.encode(v.toString());
//					}
//					ReflectionUtils.setField(fieldUtilisateur, clientEnBase.getUtilisateur(), v);
//				});
//
//			}
			Field field = ReflectionUtils.findField(Client.class, key);
			ReflectionUtils.makeAccessible(field);
			ReflectionUtils.setField(field, clientEnBase, value);
		});
		try {
			client = clientService.save(clientEnBase);
		} catch (ClientException e) {
			throw new ClientInvalidException();
		}
		return client;
	}

	@PatchMapping("/{id}/user")
	public Client updateUtilisateur(@RequestBody Map<String, Object> fields, @PathVariable Integer id) {
		Client clientEnBase = clientService.getById(id);
		Client client = null;
		if (clientEnBase.getId() == null) {
			throw new ClientInvalidException();
		}
		fields.forEach((key, value) -> {
			Field fieldUtilisateur = ReflectionUtils.findField(Utilisateur.class, key);
			ReflectionUtils.makeAccessible(fieldUtilisateur);
			if (key.equals("password")) {
				value = passwordEncoder.encode(value.toString());
			}
			ReflectionUtils.setField(fieldUtilisateur, clientEnBase.getUtilisateur(), value);
		});
		try {
			client = clientService.save(clientEnBase);
		} catch (ClientException e) {
			throw new ClientInvalidException();
		}
		return client;
	}
}
