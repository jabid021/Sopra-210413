package formationSpringMvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

@Configuration
@ComponentScan("formationSpringMvc.controller")
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/images/**").addResourceLocations("/images/");
	}

	@Bean
	public UrlBasedViewResolver viewResolver() {
		UrlBasedViewResolver uBVR = new UrlBasedViewResolver();
		uBVR.setViewClass(JstlView.class);
		uBVR.setPrefix("/WEB-INF/views/");
		uBVR.setSuffix(".jsp");
		return uBVR;
	}
}
