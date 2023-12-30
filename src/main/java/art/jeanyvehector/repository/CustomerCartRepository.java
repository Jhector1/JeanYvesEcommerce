package art.jeanyvehector.repository;

import art.jeanyvehector.model.CustomerCart;
import art.jeanyvehector.model.CustomerCartHelper;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerCartRepository extends CustomerDataRepository<CustomerCartHelper, CustomerCart> {

}
