package cloud.uwu.e_commerce.repositories.product;

import cloud.uwu.e_commerce.model.product.P_Category;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ProductCategory extends ReactiveMongoRepository<P_Category, String> {
}
