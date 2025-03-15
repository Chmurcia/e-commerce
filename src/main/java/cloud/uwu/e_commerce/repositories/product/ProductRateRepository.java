package cloud.uwu.e_commerce.repositories.product;

import cloud.uwu.e_commerce.model.product.P_Rate;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ProductRateRepository extends ReactiveMongoRepository<P_Rate, String> {
}
