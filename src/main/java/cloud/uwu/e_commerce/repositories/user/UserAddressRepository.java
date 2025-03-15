package cloud.uwu.e_commerce.repositories.user;

import cloud.uwu.e_commerce.model.user.U_Address;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface UserAddressRepository extends ReactiveMongoRepository<U_Address, String> {
}
