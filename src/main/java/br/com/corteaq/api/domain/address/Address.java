package br.com.corteaq.api.domain.address;

import br.com.corteaq.api.domain.user.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.*;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "adress")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode

public class Address implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @Column(nullable = false)
    private String street;

    @Column(name = "house_number")
    private String houseNumber;

    @Column(name = "zip_code")
    private String zipCode; // CEP

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String state;

    private String complement;
}
