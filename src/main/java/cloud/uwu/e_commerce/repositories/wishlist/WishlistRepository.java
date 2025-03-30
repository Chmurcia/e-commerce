package cloud.uwu.e_commerce.repositories.wishlist;

import cloud.uwu.e_commerce.model.wishlist.Wishlist;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface WishlistRepository extends ReactiveMongoRepository<Wishlist, String> {
    Mono<Wishlist> findByUserId(String userId);
}
