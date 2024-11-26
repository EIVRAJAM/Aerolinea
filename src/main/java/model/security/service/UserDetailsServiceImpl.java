package model.security.service;

import model.models.Cliente;
import model.repositories.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final ClienteRepository clienteRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Cliente user = clienteRepository.findByUsername(username)
                .orElseThrow(()-> new UsernameNotFoundException("Username not found"));

        return UserDetailsImpl.build(user);
    }
}
