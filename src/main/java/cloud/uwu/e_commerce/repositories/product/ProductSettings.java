package cloud.uwu.e_commerce.repositories.product;

import cloud.uwu.e_commerce.model.product.P_Settings;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ProductSettings extends ReactiveMongoRepository<P_Settings, String> {
}
