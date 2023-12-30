package art.jeanyvehector.repository;

import art.jeanyvehector.model.CustomerDataHelper;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@NoRepositoryBean
public interface CustomerDataHelperRepository<T extends  CustomerDataHelper> extends CrudRepository<T, Long> {
    void deleteAllByMyProductId(long productId);

    void deleteByMyProductId(Long aLong);
}
