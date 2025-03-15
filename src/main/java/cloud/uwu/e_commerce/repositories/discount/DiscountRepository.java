package cloud.uwu.e_commerce.repositories.discount;

import cloud.uwu.e_commerce.model.discount.Discount;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface DiscountRepository extends ReactiveMongoRepository<Discount, String> {
}
