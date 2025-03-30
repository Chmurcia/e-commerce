package cloud.uwu.e_commerce.services.wishlist;

import cloud.uwu.e_commerce.dto.wishlist.wishlist.WishlistPatchDTO;
import cloud.uwu.e_commerce.dto.wishlist.wishlist.WishlistPutDTO;
import cloud.uwu.e_commerce.dto.wishlist.wishlist.WishlistResponseDTO;
import cloud.uwu.e_commerce.exceptions.NotFoundException;
import cloud.uwu.e_commerce.mappers.wishlist.WishlistMapper;
import cloud.uwu.e_commerce.model.wishlist.Wishlist;
import cloud.uwu.e_commerce.repositories.user.UserRepository;
import cloud.uwu.e_commerce.repositories.wishlist.WishlistRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class WishlistService {
    private final UserRepository userRepository;
    private final WishlistRepository wishlistRepository;
    private final WishlistMapper mapper;

    private Mono<? extends Wishlist> returnMonoErrorAndLogWarn(String id) {
        log.warn("Wishlist with id {} not found", id);
        return Mono.error(new NotFoundException("Wishlist with id " + id + " not found"));
    }

    public Mono<WishlistResponseDTO> getWishlistByUserId(String userId) {
        return userRepository.findById(userId)
                .switchIfEmpty(Mono.defer(() -> {
                    log.warn("User with id {} not found", userId);
                    return Mono.error(new NotFoundException("User with id " + userId + " not found"));
                })).flatMap(user -> wishlistRepository.findByUserId(user.getId())
                        .map(mapper::wishlistToWishlistResponseDTO));
    }

    public Mono<WishlistResponseDTO> getWishlistById(String id) {
        return wishlistRepository.findById(id)
                .switchIfEmpty(returnMonoErrorAndLogWarn(id))
                .map(mapper::wishlistToWishlistResponseDTO);
    }

    public Mono<WishlistResponseDTO> updateWishlist(String id, WishlistPutDTO wishlist) {
        return wishlistRepository.findById(id)
                .switchIfEmpty(returnMonoErrorAndLogWarn(id))
                .flatMap(existingWishlist -> {

                    existingWishlist.setTotalAmount(wishlist.getTotalAmount());

                    return wishlistRepository.save(existingWishlist);
                })
                .map(mapper::wishlistToWishlistResponseDTO);
    }

    public Mono<WishlistResponseDTO> patchWishlist(String id, WishlistPatchDTO wishlist) {
        return wishlistRepository.findById(id)
                .switchIfEmpty(returnMonoErrorAndLogWarn(id))
                .flatMap(existingWishlist -> {
                    Optional.ofNullable(wishlist.getTotalAmount())
                            .ifPresent(existingWishlist::setTotalAmount);

                    return wishlistRepository.save(existingWishlist);
                })
                .map(mapper::wishlistToWishlistResponseDTO);
    }

    public Mono<Void> deleteWishlist(String id) {
        return wishlistRepository
                .deleteById(id)
                .switchIfEmpty(Mono.defer(() -> {
                    log.warn("Wishlist with id {} not found", id);
                    return Mono.error(new NotFoundException("Wishlist with id " + id + " not found"));
                }));
    }
}
