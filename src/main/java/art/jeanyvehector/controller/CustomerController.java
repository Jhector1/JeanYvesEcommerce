package art.jeanyvehector.controller;

import art.jeanyvehector.dto.CustomerDto;
import art.jeanyvehector.exceptionHandler.UserAlreadyExistException;
import art.jeanyvehector.model.*;
import art.jeanyvehector.repository.*;
import art.jeanyvehector.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController

@RequestMapping(path = "/customer", produces = "application/json")

public class CustomerController {
    private final CustomerRepository customerRepository;


    protected CustomerController(CustomerRepository customerRepository, UserDetailsManager userDetailsManager, PasswordEncoder encoder, CustomerService customerService) {
        this.customerRepository = customerRepository;

    }


    @DeleteMapping("/{userId}")
    @Transactional
    //  @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAllCartItem(@PathVariable("userId") String id) {
        Optional<MyCustomer> customer = customerRepository.findById(id);
        if (customer.isPresent()) {
            customerRepository.deleteById(id);
        }
    }


        // rest of the implementation

}
//
