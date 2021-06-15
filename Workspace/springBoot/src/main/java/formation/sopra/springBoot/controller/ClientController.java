package formation.sopra.springBoot.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import formation.sopra.springBoot.entities.Civilite;
import formation.sopra.springBoot.entities.Client;
import formation.sopra.springBoot.entities.Utilisateur;
import formation.sopra.springBoot.exceptions.ClientException;
import formation.sopra.springBoot.exceptions.CommandeException;
import formation.sopra.springBoot.repositories.UtilisateurRepository;
import formation.sopra.springBoot.services.ClientService;
import formation.sopra.springBoot.services.CommandeService;

@Controller
@RequestMapping("/client")
public class ClientController {

	@Autowired
	private ClientService clientService;
	@Autowired
	private CommandeService commandeService;
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private UtilisateurRepository utilisateurRepository;

	@GetMapping({ "", "/" })
	public String home() {
		return "redirect:/client/list";
	}

	@GetMapping("/list")
	public String list(Model model) {
		model.addAttribute("clients", clientService.getAll());
		return "client/list";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam Integer id) {
		clientService.delete(id);
		return "redirect:/client/list";
	}

	@GetMapping("/edit")
	public String edit(@RequestParam Integer id, Model model) {
		return goEdit(clientService.getById(id), model);
	}

	public String goEdit(Client client, Model model) {
		model.addAttribute("client", client);
		model.addAttribute("civilites", Civilite.values());
		return "client/edit";
	}

	@GetMapping("/inscription")
	public String add(Model model) {
		return goEdit(new Client(), model);
	}

	@PostMapping("/save")
	public String save(@ModelAttribute("client") @Valid Client client, BindingResult br, Model model) {
		// verifie login du client actuel en base

		// si idem=>ok

		// si different control login dispo
		Client clientEnbase = null;
		if (client.getId() != null) {
			clientEnbase = clientService.getById(client.getId());
			if (!clientEnbase.getUtilisateur().getLogin().equals(client.getUtilisateur().getLogin())) {
				// control login dispo
				if (loginDispo(client.getUtilisateur().getLogin())) {
					br.addError(new FieldError("client", "utilisateur.login", "identifiant deja utilisé"));
				}
			}

		} else {
			if (client.getUtilisateur().getLogin() != null && !client.getUtilisateur().getLogin().isEmpty()) {
				if (loginDispo(client.getUtilisateur().getLogin())) {
					br.addError(new FieldError("client", "utilisateur.login", "identifiant deja utilisé"));
				}
			}

		}

		if (br.hasErrors()) {
			return goEdit(client, model);
		}

		boolean create;
		if (client.getId() != null) {
			if (!clientEnbase.getUtilisateur().getPassword().equals(client.getUtilisateur().getPassword())) {
				client.getUtilisateur().setPassword(passwordEncoder.encode(client.getUtilisateur().getPassword()));
			}
			create = false;
		} else {
			client.getUtilisateur().setPassword(passwordEncoder.encode(client.getUtilisateur().getPassword()));
			create = true;
		}
		try {
			clientService.save(client);
		} catch (ClientException e) {
			e.printStackTrace();
		}

		if (create) {
			return "redirect:/login";
		} else {
			return "redirect:/client/list";
		}

	}

	@GetMapping("/history")
	public String historique(@RequestParam Integer id, Model model) {
		model.addAttribute("client", clientService.getByIdWithCommandes(id));
		return "client/history";
	}

	@GetMapping("/history/details")
	public String detailsCommande(@RequestParam Integer numero, Model model) {
		try {
			model.addAttribute("commande", commandeService.getById(numero));
		} catch (CommandeException e) {
			e.printStackTrace();
		}
		return "client/detailCommande";
	}

	private boolean loginDispo(String login) {
		return utilisateurRepository.findByLogin(login).isPresent();
	}
}
