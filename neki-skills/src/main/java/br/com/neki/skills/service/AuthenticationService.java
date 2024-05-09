//package br.com.neki.skills.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//
//import br.com.neki.skills.repository.PessoaRepository;
//
//public class AuthenticationService implements UserDetailsService{
//	
//	@Autowired
//	PessoaRepository pessoaRepository;
//
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		// TODO Auto-generated method stub
//		
//		 UserDetails userDetails = pessoaRepository.findByLogin(username);
//		 if (userDetails == null) {
//		        throw new UsernameNotFoundException("Usuário não encontrado: " + username);
//		    }
//		 return userDetails;
//	}
//	
//	
//
//}
