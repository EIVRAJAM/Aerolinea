package model.security;

import lombok.AllArgsConstructor;
import model.security.jwt.AuthTokenFilter;
import model.security.jwt.exception.AuthEntryPointJwt;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.List;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class WebSecurityConfig {
    private AuthEntryPointJwt unauthorizedHandler;
    private UserDetailsService userDetailsService;
    private AuthTokenFilter authTokenFilter;

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        // Orígenes permitidos
        configuration.setAllowedOrigins(List.of("http://localhost:3000")); // Define los puertos específicos
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS")); // Métodos HTTP permitidos
        configuration.setAllowedHeaders(Arrays.asList("Authorization", "Content-Type", "Accept")); // Cabeceras permitidas
        configuration.setAllowCredentials(true); // Habilita el envío de cookies o credenciales
        configuration.setExposedHeaders(List.of("Authorization")); // Si necesitas exponer cabeceras adicionales
        // Configura las rutas
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }


    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

    @Bean
    protected PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.csrf(AbstractHttpConfigurer::disable)
                .cors(c -> c.configurationSource(corsConfigurationSource()))
                .exceptionHandling(exception -> exception.authenticationEntryPoint(unauthorizedHandler))
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/auth/**").permitAll() // Acceso público
                        .requestMatchers(HttpMethod.GET,
                                "/api/v1/clientes/**",
                                "/api/v1/aeropuertos/**",
                                "/api/v1/aerolineas/**",
                                "/api/v1/vuelos/**"
                                ).hasAnyAuthority("ROLE_USER", "ROLE_ADMIN") // Cambié hasAnyRole por hasAnyAuthority
                        .requestMatchers(HttpMethod.POST, "/api/v1/clientes/**").hasAuthority("ROLE_ADMIN") // Cambié hasRole por hasAuthority
                        .requestMatchers(HttpMethod.PUT, "/api/v1/clientes/**").hasAuthority("ROLE_ADMIN") // Cambié hasRole por hasAuthority
                        .requestMatchers(HttpMethod.DELETE, "/api/v1/clientes/**").hasAuthority("ROLE_ADMIN") // Cambié hasRole por hasAuthority
                        .anyRequest().authenticated()
                );
        http.authenticationProvider(authenticationProvider());
        http.addFilterBefore(authTokenFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }
}
