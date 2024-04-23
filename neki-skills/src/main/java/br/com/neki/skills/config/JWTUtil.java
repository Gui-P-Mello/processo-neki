package br.com.neki.skills.config;

import java.util.Date;
import java.util.Optional;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import br.com.neki.skills.model.Pessoa;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JWTUtil {

  private static final String SECURITY_KEY = "ChaveDeSeguranca";

  public String gerarToken(Authentication authentication) {

    int tempoExpiracao = 86400000;
    Date dataExpiracao = new Date(new Date().getTime() + tempoExpiracao);

    Pessoa usuario = (Pessoa) authentication.getPrincipal();

    return Jwts.builder()
        .setSubject(usuario.getIdPessoa().toString())
        .setIssuedAt(new Date()) 
        .setExpiration(dataExpiracao)
        .signWith(SignatureAlgorithm.HS256, SECURITY_KEY)
        .compact(); 
  }

  public Optional<Long> obterIdDoUsuario(String token) {
    try {
    	
      Claims claims = Jwts.parser().setSigningKey(SECURITY_KEY).parseClaimsJws(token).getBody();

      return Optional.ofNullable(Long.parseLong(claims.getSubject()));

    } catch (Exception e) {

      return Optional.empty();
    }
  }

  public boolean isAuthenticated() {
    SecurityContext context = SecurityContextHolder.getContext();
    Authentication authentication = context.getAuthentication();
    return authentication != null && authentication.isAuthenticated();
  }

}