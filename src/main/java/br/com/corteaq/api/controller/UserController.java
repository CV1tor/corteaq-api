package br.com.corteaq.api.controller;

import br.com.corteaq.api.dto.UserViewDTO;
import br.com.corteaq.api.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserViewDTO>> getAll() {
        return ResponseEntity.ok(userService.getAllUsers());
    }
}
