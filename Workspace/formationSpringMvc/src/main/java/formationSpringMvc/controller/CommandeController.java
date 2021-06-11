package formationSpringMvc.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import exoJpaSpring.entity.Client;
import exoJpaSpring.entity.Commande;
import exoJpaSpring.entity.LigneCommande;
import exoJpaSpring.entity.LigneCommandeKey;
import exoJpaSpring.entity.Produit;
import exoJpaSpring.exceptions.ClientException;
import exoJpaSpring.exceptions.CommandeException;
import exoJpaSpring.exceptions.ProduitException;
import exoJpaSpring.services.ClientService;
import exoJpaSpring.services.CommandeService;
import exoJpaSpring.services.ProduitService;

@Controller
@RequestMapping("/commande")
public class CommandeController {

	@Autowired
	private ProduitService produitService;
	@Autowired
	private ClientService clientService;
	@Autowired
	private CommandeService commandeService;

	@GetMapping("/valid")
	public String validationPanier(Model model) {
		model.addAttribute("clients", clientService.getAll());
		model.addAttribute("client", new Client());
		return "commande/client";
	}

	@PostMapping("/select")
	public String selectionClient(@ModelAttribute Client client, HttpSession session) {
		Commande commande = new Commande(client);
		commande.setDate(LocalDate.now());
		Map<Produit, Integer> panier = (Map<Produit, Integer>) session.getAttribute("panier");
		List<LigneCommande> lignes = new ArrayList<LigneCommande>();
		panier.keySet().stream().forEach(produit -> {
			lignes.add(new LigneCommande(new LigneCommandeKey(produit, commande), panier.get(produit)));
		});
		commande.setLignesCommandes(lignes);
		try {
			commandeService.save(commande);
		} catch (Exception e) {
			e.printStackTrace();
		}
		session.removeAttribute("panier");
		return "redirect:/client/list";
	}

	@GetMapping("/panier")
	public String selectionProduit(HttpSession session, Model model) {
		if (session.getAttribute("panier") == null) {
			session.setAttribute("panier", new HashMap<Produit, Integer>());
		}
		model.addAttribute("produits", produitService.getAll());
		model.addAttribute("lc", new LigneCommande());
		return "commande/panier";
	}

	@PostMapping("/add")
	public String addPanier(@ModelAttribute LigneCommande lc, HttpSession session) {
		Map<Produit, Integer> panier = (Map<Produit, Integer>) session.getAttribute("panier");
		if (panier.containsKey(lc.getKey().getProduit())) {
			panier.put(lc.getKey().getProduit(), panier.get(lc.getKey().getProduit()) + lc.getQuantite());
		} else {
			try {
				panier.put(produitService.getById(lc.getKey().getProduit().getId()), lc.getQuantite());
			} catch (ProduitException e) {
				e.printStackTrace();
			}
		}
		return "redirect:/commande/panier";
	}

	@GetMapping("/show")
	public String showPanier() {
		return "commande/consultation";
	}

	@GetMapping("/remove")
	public String removeItem(@ModelAttribute Produit produit, HttpSession session) {
		Map<Produit, Integer> panier = (Map<Produit, Integer>) session.getAttribute("panier");
		panier.remove(produit);
		return "redirect:/commande/show";
	}

	@GetMapping("/cancel")
	public String annulerPanier(HttpSession session) {
		session.removeAttribute("panier");
		return "redirect:/";
	}
}
