package br.com.corteaq.api.domain.barber;

import br.com.corteaq.api.domain.servicing.Servicing;
import br.com.corteaq.api.domain.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "barber")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Barber implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User user;

    private String description;

    @ManyToMany
    @JoinTable(
            name = "barber_servicing",
            joinColumns = @JoinColumn(name = "barber_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "servicing_id", referencedColumnName = "id")
    )
    private Set<Servicing> servicings;

    public Barber (User user) {
        this.user = user;
    }
}
