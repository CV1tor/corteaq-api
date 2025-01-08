package br.com.corteaq.api.service;

import br.com.corteaq.api.domain.barber.Barber;
import br.com.corteaq.api.domain.user.User;
import br.com.corteaq.api.dto.BarberDTO;
import br.com.corteaq.api.repository.BarberRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BarberService {
    private final BarberRepository barberRepository;

    public BarberService(BarberRepository barberRepository) {
        this.barberRepository = barberRepository;
    }

    public List<BarberDTO> getAllBarbers() {
        List<Barber> barbers = barberRepository.findAll();
        return barbers.stream().map(barber ->
                new BarberDTO(
                        barber.getUser().getFirstName(),
                        barber.getUser().getLastName(),
                        barber.getUser().getTelephoneNumber(),
                        barber.getDescription(),
                        this.getBarberRating(barber)
                )).toList();
    }

    public BarberDTO getBarberById(UUID id) {
        Barber barber = findBarberById(id);
        return new BarberDTO(
                barber.getUser().getFirstName(),
                barber.getUser().getLastName(),
                barber.getUser().getTelephoneNumber(),
                barber.getDescription(),
                this.getBarberRating(barber)
        );
    }

    public void createBarber(User barberUser) {
        Barber barber = new Barber(barberUser);
        barberRepository.save(barber);
    }

    public Barber findBarberById(UUID id) {
        return barberRepository.findById(id).orElseThrow(() -> new RuntimeException("Barber not found"));
    }

    public Double getBarberRating(Barber barber) {
        return barberRepository.getAverageRatingByBarber(barber);
    }
}
