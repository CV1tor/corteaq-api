package br.com.corteaq.api.controller;

import br.com.corteaq.api.domain.user.User;
import br.com.corteaq.api.dto.LoginDTO;
import br.com.corteaq.api.dto.RegisterDTO;
import br.com.corteaq.api.dto.TokenDTO;
import br.com.corteaq.api.service.AuthenticationService;
import br.com.corteaq.api.service.TokenService;
import br.com.corteaq.api.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:3000/")
public class AuthenticationController {
    private final TokenService tokenService;
    private final AuthenticationManager authenticationManager;
    private final UserService userService;

    public AuthenticationController(AuthenticationManager authenticationManager, TokenService tokenService, UserService userService) {
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<TokenDTO> login(@RequestBody LoginDTO loginDTO) {
        var usernameAndPassword = new UsernamePasswordAuthenticationToken(loginDTO.username(), loginDTO.password());
        var auth = this.authenticationManager.authenticate(usernameAndPassword);
        var token = tokenService.generateToken((User) auth.getPrincipal());

        return ResponseEntity.ok(new TokenDTO(token));
    }

    @PostMapping("/registro")
    ResponseEntity<Void> register(@RequestBody @Valid RegisterDTO registerDTO) throws Exception {
        userService.registerUser(registerDTO);

        return ResponseEntity.ok().build();
    }
}
