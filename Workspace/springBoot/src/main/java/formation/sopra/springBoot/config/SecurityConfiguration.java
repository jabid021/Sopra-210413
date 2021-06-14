package formation.sopra.springBoot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/images/**", "/css/**", "/js/**");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// @formatter:off
		http.
			antMatcher("/**")
				.authorizeRequests()
					.antMatchers("/").permitAll()
					.antMatchers("/produit","/produit/**").hasAnyRole("ADMIN")
					.anyRequest().authenticated()
				.and()
				.formLogin();
		// @formatter:on

	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("toto").password("{noop}toto").roles("ADMIN");
		auth.inMemoryAuthentication().withUser("lolo").password("{noop}lolo").roles("USER");
	}
}
