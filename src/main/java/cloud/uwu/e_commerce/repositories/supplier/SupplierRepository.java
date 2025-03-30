package cloud.uwu.e_commerce.repositories.supplier;

import cloud.uwu.e_commerce.model.supplier.Supplier;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface SupplierRepository extends ReactiveMongoRepository<Supplier, String> {
    Mono<Supplier> findByName(String name);
    Mono<Supplier> findByEmail(String email);
    Mono<Supplier> findByPhoneNumber(String phoneNumber);
}
