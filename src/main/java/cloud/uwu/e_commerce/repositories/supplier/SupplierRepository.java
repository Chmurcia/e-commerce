package cloud.uwu.e_commerce.repositories.supplier;

import cloud.uwu.e_commerce.model.supplier.Supplier;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface SupplierRepository extends ReactiveMongoRepository<Supplier, String> {
}
