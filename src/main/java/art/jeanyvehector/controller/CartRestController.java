package art.jeanyvehector.controller;

import art.jeanyvehector.model.CustomerCart;
import art.jeanyvehector.model.CustomerCartHelper;
import art.jeanyvehector.repository.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/cart/artworks", produces = "application/json")

public class CartRestController  extends CustomerDataController<CustomerCartHelper, CustomerCartRepository, CustomerCart> {
    public CartRestController(CustomerCartRepository repository,
                              ProductRepository productRepository,
                              CustomerRepository customerRepository,
                              InventoryRepository inventoryRepository, CustomerCartHelperRepository customerCartHelperRepository) {
        super(repository, productRepository, customerRepository, inventoryRepository, customerCartHelperRepository);
    }

}
//
