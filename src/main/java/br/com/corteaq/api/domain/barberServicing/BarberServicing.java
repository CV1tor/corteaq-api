package br.com.corteaq.api.domain.barberServicing;

import br.com.corteaq.api.domain.barber.Barber;
import br.com.corteaq.api.domain.servicing.Servicing;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "barber_servicing")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class BarberServicing implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID id;

    @ManyToOne
    @JoinColumn(name = "barber_id", referencedColumnName = "id", nullable = false)
    private Barber barber;

    @ManyToOne
    @JoinColumn(name = "servicing_id", referencedColumnName = "id", nullable = false)
    private Servicing servicing;
}
