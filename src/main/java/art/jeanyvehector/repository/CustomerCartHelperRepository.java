package art.jeanyvehector.repository;

import art.jeanyvehector.model.CustomerCartHelper;
import art.jeanyvehector.model.CustomerFavoriteHelper;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerCartHelperRepository extends CustomerDataHelperRepository<CustomerCartHelper> {
}
