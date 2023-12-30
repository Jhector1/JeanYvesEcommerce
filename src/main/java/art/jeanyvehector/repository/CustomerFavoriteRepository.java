package art.jeanyvehector.repository;

import art.jeanyvehector.model.CustomerFavorite;
import art.jeanyvehector.model.CustomerFavoriteHelper;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerFavoriteRepository extends CustomerDataRepository<CustomerFavoriteHelper, CustomerFavorite> {
}
