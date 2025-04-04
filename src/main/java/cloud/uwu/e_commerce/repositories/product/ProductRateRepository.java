package cloud.uwu.e_commerce.repositories.product;

import cloud.uwu.e_commerce.model.product.P_Rate;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface ProductRateRepository extends ReactiveMongoRepository<P_Rate, String> {
    Flux<P_Rate> findByProductId(String id);

    Flux<P_Rate> findByUserId(String id);
}
