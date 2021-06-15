package formation.sopra.exo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import formation.sopra.exo.model.CustomUserDetails;
import formation.sopra.exo.services.CustomUserDetailsService;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private CustomUserDetailsService userDetailsService;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// @formatter:off
		http.antMatcher("/**")
				.authorizeRequests()
					.antMatchers("/","/public","/public/**").permitAll()
					.antMatchers("/admin","/admin/**").hasAnyRole("ADMIN")
					.antMatchers("/rh","/rh/**").hasAnyRole("RH")
					.anyRequest().permitAll()
				.and()
				.formLogin()
//					.loginPage("/login")
//					.defaultSuccessUrl("/secure")
//					.failureForwardUrl("/login?error")
//					.permitAll()
				.and()
				.logout()
					.logoutUrl("/logout")
					.logoutSuccessUrl("/public");
		// @formatter:on

	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
