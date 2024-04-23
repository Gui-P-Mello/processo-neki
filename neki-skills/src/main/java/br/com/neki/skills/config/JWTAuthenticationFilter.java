//package br.com.neki.skills.config;
//
//import java.io.IOException;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
//
//
//@Component
//public class JWTAuthenticationFilter extends OncePerRequestFilter {
//
//    @Autowired
//    private JWTUtil jwtService;
//
//    @Autowired
//    private CustomUserDetailsService customUserDetailsService;
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
//            throws ServletException, IOException {
//    	
//        String token = obterToken(request);
//
//        Optional<Long> id = jwtService.obterIdDoUsuario(token);
//
//        if (id.isPresent()) {
//
//            UserDetails usuario = customUserDetailsService.obterUserPeloId(id.get());
//
//            UsernamePasswordAuthenticationToken autenticacao = new UsernamePasswordAuthenticationToken(usuario, null,
//                    usuario.getAuthorities());
//
//            autenticacao.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//
//            SecurityContextHolder.getContext().setAuthentication(autenticacao);
//        }
//
//        filterChain.doFilter(request, response);
//
//    }
//
//    private String obterToken(HttpServletRequest request) {
//
//        String token = request.getHeader("Authorization");
//
//        if (token == null || !token.startsWith("Bearer ")) {
//            return null;
//        }
//
//        return token.substring(7);
//    }
//
//}