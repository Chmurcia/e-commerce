package cloud.uwu.e_commerce.repositories.order;

import cloud.uwu.e_commerce.model.order.O_Address;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface OrderAddressRepository extends ReactiveMongoRepository<O_Address, String> {
}
