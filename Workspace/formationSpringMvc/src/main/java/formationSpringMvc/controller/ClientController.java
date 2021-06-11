package formationSpringMvc.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import exoJpaSpring.entity.Civilite;
import exoJpaSpring.entity.Client;
import exoJpaSpring.exceptions.ClientException;
import exoJpaSpring.exceptions.CommandeException;
import exoJpaSpring.services.ClientService;
import exoJpaSpring.services.CommandeService;

@Controller
@RequestMapping("/client")
public class ClientController {

	@Autowired
	private ClientService clientService;
	@Autowired
	private CommandeService commandeService;

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

	@GetMapping("/add")
	public String add(Model model) {
		return goEdit(new Client(), model);
	}

	@PostMapping("/save")
	public String save(@ModelAttribute("client") @Valid Client client, BindingResult br, Model model) {
		if (br.hasErrors()) {
			return goEdit(client, model);
		}
		try {
			clientService.save(client);
		} catch (ClientException e) {
			e.printStackTrace();
		}
		return "redirect:/client/list";
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
}
