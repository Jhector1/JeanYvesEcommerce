package art.jeanyvehector.repository;

import art.jeanyvehector.model.MyReview;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<MyReview, Long> {
    List<MyReview> findAllByProductId(Sort sort, Long productId);
}
