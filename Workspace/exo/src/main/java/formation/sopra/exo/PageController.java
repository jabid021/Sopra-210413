package formation.sopra.exo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {
	@GetMapping("/")
	public String home() {
		return "home";
	}

	@GetMapping("/admin")
	public String admin() {
		return "admin";
	}

	@GetMapping("/public")
	public String pagePublic() {
		return "public";
	}

	@GetMapping("/rh")
	public String rh() {
		return "rh";
	}
}
