package com.example.FlashDelivery.authentication;

import com.example.FlashDelivery.Model.Client;
import com.example.FlashDelivery.Model.Livreur;
import com.example.FlashDelivery.Model.User;
import com.example.FlashDelivery.Repository.UserRipository;
import com.example.FlashDelivery.Securité.JwtService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AuthService {

    private final UserRipository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthService(UserRipository repository, PasswordEncoder passwordEncoder, JwtService jwtService, AuthenticationManager authenticationManager){
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    public AuthResponse register(RegisterRequest request) {

        if (request.getIsLiv()){
            Livreur livreur = new Livreur(
                    null,request.getFirstName(),request.getLastName(),
                    request.getEmail(),passwordEncoder.encode(request.getPassword())
            );
            repository.save(livreur);
            Map<String, String> map = get(livreur);
            var jwtToken = jwtService.generateToken(map, livreur);
            return AuthResponse.builder()
                    .accessToken(jwtToken)
                    .build();

        }else{
            Client client = new Client(
                    null,request.getFirstName(),request.getLastName(),
                    request.getEmail(),passwordEncoder.encode(request.getPassword())

            );
            repository.save(client);
            Map<String, String> map = get(client);
            var jwtToken = jwtService.generateToken(map,client);
            return AuthResponse.builder()
                    .accessToken(jwtToken)
                    .build();
        }



    }

    public AuthResponse authenticate(AuthRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        User user = repository.findByEmail(request.getEmail())
                .orElseThrow();

        Map<String, String> map = get(user);
        var jwtToken = jwtService.generateToken(map, user);

        return AuthResponse.builder()
                .accessToken(jwtToken)
                .build();

    }

    private static Map<String, String> get(User user) {
        Map<String, String> map = new HashMap<>();
        map.put("name", user.getNom());
        return map;
    }




}
