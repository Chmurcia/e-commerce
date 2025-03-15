package cloud.uwu.e_commerce.repositories.cart;

import cloud.uwu.e_commerce.model.cart.Cart;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface CartRepository extends ReactiveMongoRepository<Cart, String> {
}
