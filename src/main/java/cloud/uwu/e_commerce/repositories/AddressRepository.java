package cloud.uwu.e_commerce.repositories;

import cloud.uwu.e_commerce.model.user.U_Address;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface AddressRepository extends ReactiveMongoRepository<U_Address, String> {
}
