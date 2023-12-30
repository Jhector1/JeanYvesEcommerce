package art.jeanyvehector.repository;

import art.jeanyvehector.model.Inventory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InventoryRepository extends CrudRepository<Inventory, String> {
    Optional<Inventory> findByIdAndQuantityEquals(String id, int quantity);
}
