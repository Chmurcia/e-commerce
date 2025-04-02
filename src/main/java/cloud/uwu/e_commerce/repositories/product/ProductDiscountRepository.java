package cloud.uwu.e_commerce.repositories.product;

import cloud.uwu.e_commerce.model.product.P_Discount;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface ProductDiscountRepository extends ReactiveMongoRepository<P_Discount, String> {
    Flux<P_Discount> findByProductId(String productId);
}
