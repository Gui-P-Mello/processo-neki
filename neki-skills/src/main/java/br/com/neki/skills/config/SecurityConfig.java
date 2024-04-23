package br.com.neki.skills.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;



@Configuration
public class SecurityConfig {
	
	 private final AuthenticationConfiguration authConfiguration;

	    @Autowired
	    public SecurityConfig(AuthenticationConfiguration authConfiguration) {
	        this.authConfiguration = authConfiguration;
	    }
	
	@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
	
	 @Bean
	    public AuthenticationManager authenticationManagerBean() throws Exception {
	        return authConfiguration.getAuthenticationManager();
	    }
	
	
//	 @Bean
//	    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//	        http
//	        	.authorizeHttpRequests()
//	        	.anyRequest().permitAll().and()
////	            .authorizeHttpRequests(auth -> auth
////	                .requestMatchers("/pessoas/cadastrar", "/pessoas/login").permitAll()
////	                .anyRequest().authenticated()
////	            )
//	            .formLogin().disable()
//	            .csrf().disable();
//	        return http.build();
//	    }
	 
	 @Bean
	    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	        http
	            .authorizeRequests()
	            .anyRequest().permitAll() // Permite o acesso a todos os endpoints sem autenticação
	            .and()
	            .formLogin().disable() // Desabilita a tela de login
	            .csrf().disable(); // Desabilita a proteção CSRF para simplificar o exemplo
	        return http.build();
	    }
	 
}
