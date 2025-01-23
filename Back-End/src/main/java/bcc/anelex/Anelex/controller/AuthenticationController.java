package bcc.anelex.Anelex.controller;

import bcc.anelex.Anelex.model.entities.Cliente;
import bcc.anelex.Anelex.model.entities.Gerente; // Import da entidade Gerente
import bcc.anelex.Anelex.model.entities.dtos.AuthenticationDTO;
import bcc.anelex.Anelex.model.entities.dtos.LoginResponseDTO;
import bcc.anelex.Anelex.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("login")
public class AuthenticationController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    TokenService tokenService;

    // Método para autenticar clientes
    @PostMapping("/cliente")
    public ResponseEntity<?> loginCliente(@RequestBody AuthenticationDTO authenticationDTO) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(
                authenticationDTO.login(),
                authenticationDTO.password()
        );
        var auth = this.authenticationManager.authenticate(usernamePassword);
        var token = tokenService.generateToken((Cliente) auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    // Método para autenticar gerentes
    @PostMapping("/gerente")
    public ResponseEntity<?> loginGerente(@RequestBody AuthenticationDTO authenticationDTO) {
        System.out.println("Iniciando autenticação para Gerente: " + authenticationDTO.login());

        try {
            var usernamePassword = new UsernamePasswordAuthenticationToken(
                    authenticationDTO.login(),
                    authenticationDTO.password()
            );
            var auth = this.authenticationManager.authenticate(usernamePassword);
            System.out.println("Autenticação concluída com sucesso: " + auth.getPrincipal());

            if (auth.getPrincipal() instanceof Gerente gerente) {
                var token = tokenService.generateTokenManager(gerente);
                return ResponseEntity.ok(new LoginResponseDTO(token));
            } else {
                throw new IllegalStateException("Principal não é do tipo Gerente.");
            }
        } catch (Exception e) {
            System.err.println("Erro durante a autenticação: " + e.getMessage());
            return ResponseEntity.badRequest().body("Erro na autenticação: " + e.getMessage());
        }
    }
}