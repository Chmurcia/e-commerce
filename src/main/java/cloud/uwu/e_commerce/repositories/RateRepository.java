package cloud.uwu.e_commerce.repositories;

import cloud.uwu.e_commerce.model.product.Rate;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface RateRepository extends ReactiveMongoRepository<Rate, String> {
}
