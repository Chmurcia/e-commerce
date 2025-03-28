package cloud.uwu.e_commerce.repositories.warehouse;

import cloud.uwu.e_commerce.model.warehouse.W_Address;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface WarehouseAddressRepository extends ReactiveMongoRepository<W_Address, String> {
    Flux<W_Address> findByWarehouseId(String warehouseId);
}
