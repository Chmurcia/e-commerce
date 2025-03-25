package cloud.uwu.e_commerce.repositories.user;

import cloud.uwu.e_commerce.model.user.U_Address;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface UserAddressRepository extends ReactiveMongoRepository<U_Address, String> {
    Flux<U_Address> findByUserId(String userId);
}
