package cloud.uwu.e_commerce.repositories;

import cloud.uwu.e_commerce.model.product.Multimedia;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface MultimediaRepository extends ReactiveMongoRepository<Multimedia, String> {
}
