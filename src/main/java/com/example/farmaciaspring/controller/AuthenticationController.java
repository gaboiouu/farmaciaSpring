package com.example.farmaciaspring.controller;

import com.example.farmaciaspring.model.User;
import com.example.farmaciaspring.service.UserService;
import com.example.farmaciaspring.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserService userService;

    @PostMapping("/authenticate")
    public ResponseEntity<?> authenticate(@RequestParam String username, @RequestParam String password) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username, password)
            );

            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            String token = jwtUtil.generateToken(
                    userDetails.getUsername(),
                    userDetails.getAuthorities().iterator().next().getAuthority()
            );

            User user = userService.findByUsername(username);
            Map<String, Object> response = new HashMap<>();
            response.put("token", token);
            response.put("user", new HashMap<String, Object>() {{
                put("id", user.getId());
                put("username", user.getUsername());
                put("nombre", user.getNombre());
                put("apellido", user.getApellido());
                put("email", user.getEmail());
                put("role", user.getRoles().iterator().next().getName());
            }});

            return ResponseEntity.ok(response);

        }catch (BadCredentialsException e) {
                System.out.println("BadCredentialsException: " + e.getMessage());
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                        .body("Credenciales inválidas");
            } catch (Exception e) {
                System.out.println("Exception: " + e.getMessage());
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body("Error de autenticación: " + e.getMessage());
            }
    }
}