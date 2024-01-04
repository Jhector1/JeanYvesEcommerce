package art.jeanyvehector.controller;

import art.jeanyvehector.helper.Helper;
import art.jeanyvehector.model.MyCustomer;
import art.jeanyvehector.repository.CustomerRepository;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@ControllerAdvice
@Controller
@RequestMapping("/account")
@SessionAttributes({"sessionId"})
public class ProfileController {
    private final CustomerRepository customerRepository;

    public ProfileController(CustomerRepository repository) {
        this.customerRepository = repository;
    }

    @GetMapping("/{sessionId}/profile")
    public String getProfilePage(Model model, HttpServletResponse response){
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication a = context.getAuthentication();
        Optional<MyCustomer> customer = customerRepository.findByEmail(a.getPrincipal().toString());
       customer.ifPresent(myCustomer ->{
           model.addAttribute("secret", myCustomer.getId());
           model.addAttribute("fullName", (customer.get().getFullName()==null)?"Anonymous": customer.get().getFullName());
       });

        String mysession = a.getDetails().toString().split(",")[1];
        String sessionId = mysession.substring(11,mysession.length()-1 );


        model.addAttribute( "sessionId" ,sessionId);
        Helper.setCookieValue("session_Id", sessionId, response);

//        System.out.println("details: "+a.getDetails());
//        System.out.println("principal:  "+a.getPrincipal());
//        Cookie myCookie = new Cookie("my-session-id", sessionId);
//
//        // Set the cookie's max age (in seconds)
//        myCookie.setMaxAge(36000); // 1 hour (you can adjust this as needed)
//
//        // Set the cookie path (optional)
//        myCookie.setPath("/");
//
//        // Add the cookie to the response
//        response.addCookie(myCookie);

        return "authenticated/userProfile";

    }
    @ModelAttribute
    public static  String getSessionId(){
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication a = context.getAuthentication();


        String mysession;
        String sessionId ;
        if(a==null){
            sessionId = UUID.randomUUID().toString();
        }
        else {
            mysession = a.getDetails().toString().split(",")[1];

            sessionId = mysession.substring(11, mysession.length() - 1);
        } return sessionId;
    }

}
