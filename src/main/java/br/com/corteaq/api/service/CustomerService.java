package br.com.corteaq.api.service;

import br.com.corteaq.api.domain.customer.Customer;
import br.com.corteaq.api.domain.user.User;
import br.com.corteaq.api.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void createCustomer(User customerUser) {
        Customer customer = new Customer(customerUser);
        customerRepository.save(customer);
    }
}
