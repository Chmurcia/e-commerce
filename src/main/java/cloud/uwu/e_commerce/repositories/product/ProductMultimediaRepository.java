package cloud.uwu.e_commerce.repositories.product;

import cloud.uwu.e_commerce.model.product.P_Multimedia;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface ProductMultimediaRepository extends ReactiveMongoRepository<P_Multimedia, String> {
    Flux<P_Multimedia> findByProductId(String productId);
}
