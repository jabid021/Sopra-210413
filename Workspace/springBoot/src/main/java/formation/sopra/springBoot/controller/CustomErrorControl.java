package formation.sopra.springBoot.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

//@Controller
public class CustomErrorControl implements ErrorController {
	@GetMapping("/error")
	public ModelAndView traitementErreur(HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView();
		if (response.getStatus() == HttpStatus.NOT_FOUND.value()) {
			modelAndView.setViewName("error/error404");
		} else if (response.getStatus() == HttpStatus.FORBIDDEN.value()) {
			modelAndView.setViewName("error/error403");
		} else if (response.getStatus() == HttpStatus.BAD_REQUEST.value()) {
			modelAndView.setViewName("error/error");
		} else {
			modelAndView.setViewName("error/error");
		}
		return modelAndView;
	}

	@Override
	public String getErrorPath() {
		return "/error";
	}

}
