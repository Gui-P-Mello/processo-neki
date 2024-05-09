//package br.com.neki.skills.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//import org.springframework.security.web.util.matcher.OrRequestMatcher;
//import org.springframework.security.web.util.matcher.RequestMatcher;
//
//
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//	
//	@Autowired
//	SecurityFilter securityFilter;
//	
//	@Bean
//	SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
//		RequestMatcher swaggerUiMatcher = new OrRequestMatcher(
//	            new AntPathRequestMatcher("/swagger-ui/**"),
//	            new AntPathRequestMatcher("/v3/api-docs/**"),
//	            new AntPathRequestMatcher("/swagger-ui.html"),
//	            new AntPathRequestMatcher("/webjars/**")
//	        );
//		return httpSecurity
//			.csrf(csrf -> csrf.disable())
//			.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//			.authorizeHttpRequests(authorize -> authorize
//					.requestMatchers("/swagger-ui/**", "/v3/api-docs/**", "/swagger-ui.html", "/webjars/**").permitAll()
//					.requestMatchers(HttpMethod.POST).permitAll()
////					.requestMatchers(HttpMethod.POST, "/login/register").permitAll()
//					.anyRequest().permitAll()
//					)
//			.addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class)
//			.build();
//		
//	}
//	
//	@Bean
//	AuthenticationManager authenticationManager(AuthenticationConfiguration authConfiguration) throws Exception {
//		return authConfiguration.getAuthenticationManager();		
//	}
//	
//	
//	@Bean
//	PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
//}
