package bcc.anelex.Anelex.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Autowired
    private CustumClientDetailsService custumClientDetailsService;
    @Autowired
    ClientSecurityFilter clientSecurityFilter;
    @Autowired
    ManagerSecurityFilter managerSecurityFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        return http
                .csrf(csrf -> csrf.disable())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers(HttpMethod.GET, "/gerente").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.GET, "/relatorioVendas").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.POST, "/produto").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.POST, "/gerente").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.POST, "/relatorioVendas").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.POST, "/cliente/login").permitAll()
                        .requestMatchers(HttpMethod.POST, "/cliente").permitAll()
                        .requestMatchers(HttpMethod.POST, "/gerente/login").permitAll()
                        .requestMatchers(HttpMethod.POST, "/gerente").permitAll()
                        .requestMatchers(HttpMethod.PUT, "/produto").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT, "/gerente").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT, "/relatorioVendas").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE, "/produto").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE, "/gerente").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE, "/cliente").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE, "/relatorioVendas").hasRole("MANAGER")
                        .anyRequest().authenticated()
                )
                .addFilterBefore(clientSecurityFilter, UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(managerSecurityFilter, ClientSecurityFilter.class)
                .build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}