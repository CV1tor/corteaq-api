package br.com.corteaq.api.domain.appointment;

import br.com.corteaq.api.domain.barber.Barber;
import br.com.corteaq.api.domain.customer.Customer;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "appointment")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Appointment implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "barber_id", referencedColumnName = "id")
    private Barber barber;

    @Column(nullable = false)
    private LocalDateTime dateTime;

    @Column(nullable = false)
    private AppointmentStatus status = AppointmentStatus.PENDING;

    private AppointmentRating rating;

    private String customerComment;

}
