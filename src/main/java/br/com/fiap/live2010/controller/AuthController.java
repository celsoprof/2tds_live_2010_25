package br.com.fiap.live2010.controller;

import br.com.fiap.live2010.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Usuario usuario) {

        UsernamePasswordAuthenticationToken userNamePassword =
                new UsernamePasswordAuthenticationToken(usuario.getEmail(), usuario.getSenha());

        Authentication authentication = authenticationManager.authenticate(userNamePassword);

        return ResponseEntity.ok().build();
    }

}
