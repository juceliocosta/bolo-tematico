package com.java.bolo_tematico.controller;

import com.java.bolo_tematico.model.User;
import com.java.bolo_tematico.service.AuthService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService auth;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestParam String username, @RequestParam String password, HttpSession session) {
        User user = auth.login(username, password);
        if (user != null) {
            session.setAttribute("user", user);
            return ResponseEntity.ok(user.getRole()); // retorna o tipo do usuário
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciais inválidas"); //Retornar dados no corpo
    }

    @GetMapping("/logout")
    public ResponseEntity<Void> logout(HttpSession session, HttpServletResponse response) throws IOException {
        session.invalidate(); // Encerra a sessão
        response.sendRedirect("/login.html"); // Redireciona para a página de login
        return ResponseEntity.ok().build(); //Retornar sem corpo
    }
}

