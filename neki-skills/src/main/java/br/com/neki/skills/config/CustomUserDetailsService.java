//package br.com.neki.skills.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import br.com.neki.skills.repository.PessoaRepository;
//
//@Service
//public class CustomUserDetailsService implements UserDetailsService {
//
//    @Autowired
//    private PessoaRepository pessoaRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//    	
//        return pessoaRepository.findByLogin(username).get();
//    }
//
//    public UserDetails obterUserPeloId(Long id) {
//        return pessoaRepository.findByIdPessoa(id).get();
//    }
//
//}
//
