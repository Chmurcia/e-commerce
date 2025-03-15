package cloud.uwu.e_commerce.repositories.cart;

import cloud.uwu.e_commerce.model.cart.C_Item;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface CartItemRepository extends ReactiveMongoRepository<C_Item, String> {
}
