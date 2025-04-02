package cloud.uwu.e_commerce.services.product;

import cloud.uwu.e_commerce.dto.product.productDiscount.P_DiscountPostDTO;
import cloud.uwu.e_commerce.dto.product.productDiscount.P_DiscountPutDTO;
import cloud.uwu.e_commerce.dto.product.productDiscount.P_DiscountResponseDTO;
import cloud.uwu.e_commerce.exceptions.NotFoundException;
import cloud.uwu.e_commerce.mappers.product.ProductDiscountMapper;
import cloud.uwu.e_commerce.mappers.product.ProductMapper;
import cloud.uwu.e_commerce.model.product.P_Discount;
import cloud.uwu.e_commerce.model.wishlist.W_Item;
import cloud.uwu.e_commerce.repositories.product.ProductDiscountRepository;
import cloud.uwu.e_commerce.repositories.product.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductDiscountService {
    private final ProductRepository productRepository;
    private final ProductDiscountRepository productDiscountRepository;
    private final ProductDiscountMapper mapper;

    private Mono<? extends P_Discount> returnMonoErrorAndLogWarn(String id) {
        log.warn("ProductDiscount with id {} not found", id);
        return Mono.error(new NotFoundException("ProductDiscount with id " + id + " not found"));
    }

    public Flux<P_DiscountResponseDTO> getProductDiscountsByProductId(String productId) {
        return productRepository.findById(productId)
                .switchIfEmpty(Mono.defer(() -> {
                    log.warn("ProductDiscount with id {} not found", productId);
                    return Mono.error(new NotFoundException("Product with id "+ productId + " not found"));
                }))
                .flatMapMany(product -> productDiscountRepository
                        .findByProductId(product.getId())
                        .mapNotNull(mapper::productDiscountToProductDiscountResponseDTO)
                        .switchIfEmpty(Flux.defer(() -> {
                            log.warn("No ProductDiscounts found for product with id {}", productId);
                            return Flux.empty();
                        })));
    }

    public Mono<P_DiscountResponseDTO> getProductDiscountById(String id) {
        return productDiscountRepository.findById(id)
                .switchIfEmpty(returnMonoErrorAndLogWarn(id))
                .map(mapper::productDiscountToProductDiscountResponseDTO);
    }

    public Mono<P_DiscountResponseDTO> createProductDiscount(P_DiscountPostDTO pDiscount) {
        return productDiscountRepository
                .save(mapper.productDiscountPostDTOToProductDiscount(pDiscount))
                .map(mapper::productDiscountToProductDiscountResponseDTO);
    }

    public Mono<P_DiscountResponseDTO> updateProductDiscount(String id, P_DiscountPutDTO pDiscount) {
        return productDiscountRepository.findById(id)
                .switchIfEmpty(returnMonoErrorAndLogWarn(id))
                .flatMap(existingDiscount -> {
                    existingDiscount.setIsActive(pDiscount.getIsActive());

                    return productDiscountRepository.save(existingDiscount);
                })
                .map(mapper::productDiscountToProductDiscountResponseDTO);
    }

    public Mono<P_DiscountResponseDTO> patchProductDiscount(String id, P_DiscountPutDTO pDiscount) {
        return productDiscountRepository.findById(id)
                .switchIfEmpty(returnMonoErrorAndLogWarn(id))
                .flatMap(existingDiscount -> {
                    Optional.ofNullable(pDiscount.getIsActive())
                            .ifPresent(existingDiscount::setIsActive);

                    return productDiscountRepository.save(existingDiscount);
                })
                .map(mapper::productDiscountToProductDiscountResponseDTO);
    }

    public Mono<Void> deleteProductDiscount(String id) {
        return productDiscountRepository
                .deleteById(id)
                .switchIfEmpty(Mono.defer(() -> {
                    log.warn("ProductDiscount with id {} not found", id);
                    return Mono.error(new NotFoundException("ProductDiscount with id " + id + " not found"));
                }));
    }
}
