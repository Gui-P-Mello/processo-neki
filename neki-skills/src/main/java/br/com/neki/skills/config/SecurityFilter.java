//package br.com.neki.skills.config;
//
//import java.io.IOException;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import br.com.neki.skills.repository.PessoaRepository;
//import br.com.neki.skills.service.TokenService;
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
//@Component
//public class SecurityFilter extends OncePerRequestFilter{
//	
//	@Autowired 
//	TokenService tokenService;
//	
//	@Autowired 
//	PessoaRepository pessoaRepository; 
//
//	@Override
//	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
//			throws ServletException, IOException {
//		var token = this.recoverToken(request);
//		if(token!=null) {
//			var login = tokenService.validateToken(token);
//			UserDetails pessoa = pessoaRepository.findByLogin(login);
//			
//			var authentication = new UsernamePasswordAuthenticationToken(pessoa, pessoa.getAuthorities());
//			SecurityContextHolder.getContext().setAuthentication(authentication);
//		}
//		filterChain.doFilter(request, response);
//		
//	}
//	
//	private String recoverToken(HttpServletRequest request) {
//		var authReader = request.getHeader("Authorization");
//		if(authReader==null) return null;
//		return authReader.replace("Bearer", "");
//	}
//	
//
//}
