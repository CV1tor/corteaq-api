package br.com.corteaq.api.service;

import br.com.corteaq.api.domain.barber.Barber;
import br.com.corteaq.api.domain.customer.Customer;
import br.com.corteaq.api.domain.user.User;
import br.com.corteaq.api.domain.user.UserType;
import br.com.corteaq.api.dto.RegisterDTO;
import br.com.corteaq.api.dto.UserViewDTO;
import br.com.corteaq.api.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final BarberService barberService;
    private final CustomerService customerService;

    public UserService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder, BarberService barberService, CustomerService customerService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.barberService = barberService;
        this.customerService = customerService;
    }

    public List<UserViewDTO> getAllUsers() {
        return userRepository.findAll().stream().map(user ->
                        new UserViewDTO(user.getId(),
                                user.getUsername(),
                                user.getFirstName(),
                                user.getLastName(),
                                user.getTelephoneNumber(),
                                user.getUserType()))
                .collect(Collectors.toList());
    }

    public void registerUser(RegisterDTO registerDTO) throws Exception {
        if (userRepository.findByUsername(registerDTO.username()).isPresent()) {
            throw new Exception("Usuário já cadastrado!");
        }
        var encryptedPassword = passwordEncoder.encode(registerDTO.password());

        User user = new User(registerDTO.username(),
                encryptedPassword,
                registerDTO.firstName(),
                registerDTO.lastName(),
                registerDTO.telephoneNumber(),
                registerDTO.userType());

        userRepository.save(user);

        if (user.getUserType() == UserType.BARBER) {
            barberService.createBarber(user);
        } else if (user.getUserType() == UserType.CUSTOMER) {
            customerService.createCustomer(user);
        }
    }
}
