package cloud.uwu.e_commerce.repositories.product;

import cloud.uwu.e_commerce.model.product.P_Discount;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ProductDiscountRepository extends ReactiveMongoRepository<P_Discount, String> {
}
