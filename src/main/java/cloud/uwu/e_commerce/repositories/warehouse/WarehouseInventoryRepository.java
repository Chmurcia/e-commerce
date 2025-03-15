package cloud.uwu.e_commerce.repositories.warehouse;

import cloud.uwu.e_commerce.model.warehouse.W_Inventory;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface WarehouseInventoryRepository extends ReactiveMongoRepository<W_Inventory, String> {
}
