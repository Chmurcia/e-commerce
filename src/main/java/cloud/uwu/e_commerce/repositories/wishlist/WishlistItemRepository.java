package cloud.uwu.e_commerce.repositories.wishlist;

import cloud.uwu.e_commerce.model.wishlist.W_Item;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface WishlistItemRepository extends ReactiveMongoRepository<W_Item, String> {
    Flux<W_Item> findByWishlistId(String warehouseId);
}
