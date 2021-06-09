package formationSpringMvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MonController {
	@RequestMapping("/hello")
	public String hello(Model model,
			@RequestParam(name = "prenom", required = false, defaultValue = "le monde") String prenom,
			@RequestParam(name = "n", required = false, defaultValue = "0") Integer n) {
		model.addAttribute("prenom", prenom);
		model.addAttribute("n", n);
		return "page";
	}
}
