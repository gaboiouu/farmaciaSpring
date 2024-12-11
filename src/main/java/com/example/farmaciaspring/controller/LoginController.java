/*package com.example.farmaciaspring.controller;

import com.example.farmaciaspring.model.User;
import com.example.farmaciaspring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;

@RestController
@RequestMapping("/api/login")
@PreAuthorize("hasRole('ADMIN')")
public class LoginController {
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<String> login(@RequestBody User user) {
        boolean esValido = userService.validarCredenciales(user.getUsername(), user.getPassword());
        if (esValido) {
            return ResponseEntity.ok("Login exitoso");
        } else {
            return ResponseEntity.status(401).body("Credenciales incorrectas");
        }
    }
}*/
