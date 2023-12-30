package art.jeanyvehector.repository;

import art.jeanyvehector.model.MyProduct;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface ProductRepository extends CrudRepository<MyProduct, Long> {

}
