package cloud.uwu.e_commerce.repositories.warehouse;

import cloud.uwu.e_commerce.model.warehouse.W_Address;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface WarehouseAddressRepository extends ReactiveMongoRepository<W_Address, String> {
}
