package cloud.uwu.e_commerce.services.wishlist;

import cloud.uwu.e_commerce.dto.wishlist.wishlistItem.W_ItemPostDTO;
import cloud.uwu.e_commerce.dto.wishlist.wishlistItem.W_ItemResponseDTO;
import cloud.uwu.e_commerce.exceptions.NotFoundException;
import cloud.uwu.e_commerce.mappers.wishlist.WishlistItemMapper;
import cloud.uwu.e_commerce.model.wishlist.W_Item;
import cloud.uwu.e_commerce.repositories.wishlist.WishlistItemRepository;
import cloud.uwu.e_commerce.repositories.wishlist.WishlistRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@RequiredArgsConstructor
public class WishlistItemService {
    private final WishlistRepository wishlistRepository;
    private final WishlistItemRepository wishlistItemRepository;
    private final WishlistItemMapper mapper;

    private Mono<? extends W_Item> returnMonoErrorAndLogWarn(String id) {
        log.warn("WishlistItem with id {} not found", id);
        return Mono.error(new NotFoundException("WishlistItem with id " + id + " not found"));
    }

    public Flux<W_ItemResponseDTO> getWishlistItemByWishlistId(String wishlistId) {
        return wishlistRepository.findById(wishlistId)
                .switchIfEmpty(Mono.defer(() -> {
                    log.warn("Wishlist with id {} not found", wishlistId);
                    return Mono.error(new NotFoundException("Wishlist with id " + wishlistId + " not found"));
                }))
                .flatMapMany(wishlist -> wishlistItemRepository.findByWishlistId(wishlist.getId()))
                    .mapNotNull(mapper::wishlistItemToWishlistItemResponseDTO)
                .switchIfEmpty(Flux.defer(() -> {
                    log.warn("No wishlistItems found for wishlist with id {}", wishlistId);
                    return Flux.empty();
                }));
    }

    public Mono<W_ItemResponseDTO> getWishlistItemById(String id) {
        return wishlistItemRepository.findById(id)
                .switchIfEmpty(returnMonoErrorAndLogWarn(id))
                .map(mapper::wishlistItemToWishlistItemResponseDTO);
    }

    public Mono<W_ItemResponseDTO> createWishlistItem(W_ItemPostDTO wItem) {
        return wishlistItemRepository
                .save(mapper.wishlistItemPostDTOToWishlistItem(wItem))
                .map(mapper::wishlistItemToWishlistItemResponseDTO);
    }

    public Mono<Void> deleteWishlistItem(String id) {
        return wishlistItemRepository
                .deleteById(id)
                .switchIfEmpty(Mono.defer(() -> {
                    log.warn("WishlistItem with id {} not found", id);
                    return Mono.error(new NotFoundException("WishlistItem with id " + id + " not found"));
                }));
    }
}
