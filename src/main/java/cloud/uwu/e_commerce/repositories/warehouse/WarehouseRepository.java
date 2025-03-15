package cloud.uwu.e_commerce.repositories.warehouse;

import cloud.uwu.e_commerce.model.warehouse.Warehouse;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface WarehouseRepository extends ReactiveMongoRepository<Warehouse, String> {
}
