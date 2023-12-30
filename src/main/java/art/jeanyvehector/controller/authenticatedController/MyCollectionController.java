package art.jeanyvehector.controller.authenticatedController;

import art.jeanyvehector.controller.ProfileController;
import art.jeanyvehector.model.MyCustomer;
import art.jeanyvehector.model.MyOrder;
import art.jeanyvehector.model.MyProduct;
import art.jeanyvehector.repository.CustomerRepository;
import art.jeanyvehector.repository.OrderRepository;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@RequestMapping(path = "/account", produces = "application/json")
@Slf4j
public class MyCollectionController {
    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;

    public MyCollectionController(OrderRepository orderRepository, CustomerRepository customerRepository) {
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
    }

    @GetMapping("{sessionId}/collections")
    public String getCollectionPage(Model model, @PathVariable String sessionId, HttpServletRequest request) throws Exception {
        if (!ProfileController.getSessionId().equals(sessionId)) {
            throw new Exception();
        }
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication a = context.getAuthentication();


//        Cookie[] cookies = request.getCookies();
//        String userId = null;
//        // Check if cookies exist
//        if (cookies != null) {
//
//            for (Cookie cookie : cookies) {
//                // Check if the current cookie has the name "useriod"
//                if ("user12345".equals(cookie.getName())) {
//                    // Get the value of the "useriod" cookie
//                     userId = cookie.getValue();
//
//                    // Do something with the "useriod" cookie value
//                    log.info("Value of user Id cookie: {}" , userId);
//                }
//            }
//        } else {
//           log.error("No cookies found in the request.");
//        }
        Optional<MyCustomer> customer = customerRepository.findByEmail(a.getPrincipal().toString());
        if (customer.isPresent()) {
            Iterable<MyProduct> products = customer.get().getMyOrders().stream().map(MyOrder::getMyProducts).flatMap(List::stream).collect(Collectors.toList());
            if(products.iterator().hasNext()) {
                model.addAttribute("myOrders", products);
                model.addAttribute("allArtParent", "allArtParent");
            }
            else{
                model.addAttribute("allArtParent", false);
            }

        }


        return "/authenticated/my-collection";
    }
}
