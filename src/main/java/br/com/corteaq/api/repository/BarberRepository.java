package br.com.corteaq.api.repository;

import br.com.corteaq.api.domain.barber.Barber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface BarberRepository extends JpaRepository<Barber, UUID> {


    @Query("SELECT AVG(a.rating) FROM Appointment a WHERE a.barber = :barber")
    Double getAverageRatingByBarber(Barber barber);


}
