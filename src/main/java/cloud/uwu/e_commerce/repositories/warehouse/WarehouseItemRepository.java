package cloud.uwu.e_commerce.repositories.warehouse;

import cloud.uwu.e_commerce.model.wishlist.W_Item;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface WarehouseItemRepository extends ReactiveMongoRepository<W_Item, String> {
}
