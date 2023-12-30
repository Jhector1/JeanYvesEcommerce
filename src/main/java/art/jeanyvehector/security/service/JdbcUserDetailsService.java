package art.jeanyvehector.security.service;

import art.jeanyvehector.model.MyCustomer;
import art.jeanyvehector.repository.CustomerRepository;
import art.jeanyvehector.security.user.SecurityUserDetails;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
//@Qualifier("jdbcUserDetailsService")
public class JdbcUserDetailsService implements UserDetailsService {
    private final CustomerRepository customerRepository;
    private final List<SecurityUserDetails> users = new ArrayList<>();


    public JdbcUserDetailsService(CustomerRepository customerRepository) {

        this.customerRepository = customerRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        SecurityUserDetails userDetails;
        Optional<MyCustomer> optionalMyCustomer = customerRepository.findByEmail(username);
        if (optionalMyCustomer.isPresent()) {
            userDetails = new SecurityUserDetails(optionalMyCustomer.get());
        } else {
            System.out.println("User not found");
            throw new UsernameNotFoundException("User not found");

        }
        return userDetails;
    }
//    return users.stream()
//      .filter(
//         u -> u.getUsername().equals(username)
//      )
//      .findFirst()
//      .orElseThrow(
//        () -> new UsernameNotFoundException("User not found")
//      );
//   }
}