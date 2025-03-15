package cloud.uwu.e_commerce.repositories.product;

import cloud.uwu.e_commerce.model.product.P_Tag;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ProductTagRepository extends ReactiveMongoRepository<P_Tag, String> {
}
