package cloud.uwu.e_commerce.repositories.product;

import cloud.uwu.e_commerce.model.product.P_Category;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface ProductCategoryRepository extends ReactiveMongoRepository<P_Category, String> {
    Flux<P_Category> findByProductId(String productId);
}
