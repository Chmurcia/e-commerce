package cloud.uwu.e_commerce.repositories.wishlist;

import cloud.uwu.e_commerce.model.wishlist.Wishlist;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface WishlistRepository extends ReactiveMongoRepository<Wishlist, String> {
}
