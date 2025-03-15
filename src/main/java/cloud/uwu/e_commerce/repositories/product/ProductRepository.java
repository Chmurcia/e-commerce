package cloud.uwu.e_commerce.repositories.product;

import cloud.uwu.e_commerce.model.product.Product;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends ReactiveMongoRepository<Product, String> {
}
