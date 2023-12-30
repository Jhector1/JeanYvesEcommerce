package art.jeanyvehector.security.config;

import art.jeanyvehector.security.service.JdbcUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

import javax.sql.DataSource;

@Configuration
public class UserManagementConfig {

  @Bean
  public JdbcUserDetailsManager userDetailsService(DataSource dataSource) {
    String usersByUsernameQuery =
            "select email, password, enabled from my_customer where email = ?";
    String authsByUserQuery =
            "select email, authority from my_customer where email = ?";

    var userDetailsManager = new JdbcUserDetailsManager(dataSource);
    userDetailsManager.setUsersByUsernameQuery(usersByUsernameQuery);userDetailsManager.setAuthoritiesByUsernameQuery(authsByUserQuery);
    return userDetailsManager;
  }



  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
}