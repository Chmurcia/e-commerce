package cloud.uwu.e_commerce.repositories.product;

import cloud.uwu.e_commerce.model.product.P_Variant;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ProductVariantRepository extends ReactiveMongoRepository<P_Variant, String> {
}
