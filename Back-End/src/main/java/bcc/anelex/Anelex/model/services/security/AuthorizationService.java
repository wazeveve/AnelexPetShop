package bcc.anelex.Anelex.model.services.security;

import bcc.anelex.Anelex.model.repositories.ClienteRepository;
import bcc.anelex.Anelex.model.repositories.GerenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthorizationService implements UserDetailsService {
    @Autowired
    ClienteRepository clienteRepository;
    @Autowired
    GerenteRepository gerenteRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Buscar primeiro no repositório de clientes
        var cliente = clienteRepository.findByEmail(username);
        if (cliente != null) {
            return cliente;
        }

        // Buscar no repositório de gerentes
        var gerente = gerenteRepository.findByEmail(username);
        if (gerente != null) {
            return gerente;
        }

        throw new UsernameNotFoundException("Usuário não encontrado");
    }
}
