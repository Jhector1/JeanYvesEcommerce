package art.jeanyvehector.security.config;

import art.jeanyvehector.controller.ProfileController;
import art.jeanyvehector.security.component.authenticationProvider.CustomAuthenticationProvider;
import art.jeanyvehector.security.service.JdbcUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebAuthorizationConfig {

    private final CustomAuthenticationProvider authenticationProvider;

    public WebAuthorizationConfig(

            CustomAuthenticationProvider authenticationProvider) {

        this.authenticationProvider = authenticationProvider;
    }


    //    @Bean
//    MyUser getCystomer(MyUser myCustomer){
//        return myCustomer;
//    }
    @Bean
    SecurityFilterChain configure(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(
                c -> {

                    c.requestMatchers("/account/**")
                            .authenticated();
                    c.anyRequest()
                            .permitAll();

                });
        //.formLogin(Customizer.withDefaults())
        http
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/account/"+ ProfileController.getSessionId()+"/profile", true)
                .and().logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login") //.loginProcessingUrl("/authenticate")
//            .usernameParameter("username")
//            .passwordParameter("password")
                .permitAll();

        http.authenticationProvider(authenticationProvider);

        //http.addFilterBefore(new RequestValidationFilter(), BasicAuthenticationFilter.class);
        http.csrf().disable().headers().frameOptions().disable();
        return http.build();
    }
}