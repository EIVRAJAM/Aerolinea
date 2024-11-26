package model.controllers;

import lombok.AllArgsConstructor;
import model.dto.JwtResponse;
import model.dto.LoginRequest;
import model.dto.SignupRequest;
import model.models.Cliente;
import model.models.ERol;
import model.models.Rol;
import model.repositories.ClienteRepository;
import model.repositories.RolRepository;
import model.security.jwt.JwtUtil;
import model.security.service.UserDetailsImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/auth")
@AllArgsConstructor
public class AuthenticationController{
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final ClienteRepository userRepository;
    private final RolRepository rolRepository;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.username(),
                        loginRequest.password())
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwtToken= jwtUtil.generateJwtToken(authentication);
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        List<String> roles = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority).collect(Collectors.toList());

        return ResponseEntity.ok(new JwtResponse(jwtToken, "Bearer ", userDetails.getUsername(), roles));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody SignupRequest sRequest){
        Set<Rol> roles = new HashSet<>();
        roles.add(rolRepository.findByRole(ERol.ROLE_USER));

        Cliente cliente = new Cliente(
                null,
                sRequest.nombre(),
                sRequest.apellidos(),
                sRequest.direccion(),
                sRequest.telefono(),
                null,
                sRequest.username(),
                passwordEncoder.encode(sRequest.password()),
                sRequest.email(),
                roles
        );

        Cliente newCliente = userRepository.save(cliente);

        return ResponseEntity.ok(newCliente);
    }
}