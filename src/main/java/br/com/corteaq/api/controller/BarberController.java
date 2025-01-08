package br.com.corteaq.api.controller;

import br.com.corteaq.api.dto.BarberDTO;
import br.com.corteaq.api.service.BarberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/barbeiros")
public class BarberController {
    private final BarberService barberService;

    public BarberController(BarberService barberService) {
        this.barberService = barberService;
    }

    @GetMapping
    public ResponseEntity<List<BarberDTO>> getAll() {
        List<BarberDTO> barbers = barberService.getAllBarbers();
        return ResponseEntity.ok(barbers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BarberDTO> getBarberById(@PathVariable UUID id) {
        BarberDTO barber = barberService.getBarberById(id);
        return ResponseEntity.ok(barber);
    }
}
