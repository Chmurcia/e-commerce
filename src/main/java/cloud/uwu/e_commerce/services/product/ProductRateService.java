package cloud.uwu.e_commerce.services.product;

import cloud.uwu.e_commerce.dto.product.productRate.P_RatePatchDTO;
import cloud.uwu.e_commerce.dto.product.productRate.P_RatePostDTO;
import cloud.uwu.e_commerce.dto.product.productRate.P_RatePutDTO;
import cloud.uwu.e_commerce.dto.product.productRate.P_RateResponseDTO;
import cloud.uwu.e_commerce.exceptions.NotFoundException;
import cloud.uwu.e_commerce.mappers.product.ProductRateMapper;
import cloud.uwu.e_commerce.model.product.P_Rate;
import cloud.uwu.e_commerce.repositories.product.ProductRateRepository;
import cloud.uwu.e_commerce.repositories.product.ProductRepository;
import cloud.uwu.e_commerce.repositories.user.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductRateService {
    private final ProductRepository productRepository;
    private final UserRepository userRepository;
    private final ProductRateRepository productRateRepository;
    private final ProductRateMapper mapper;

    private Mono<? extends P_Rate> returnMonoErrorAndLogWarn(String id) {
        log.warn("ProductRate with id {} not found", id);
        return Mono.error(new NotFoundException("ProductRate with id " + id + " not found"));
    }

    Flux<P_RateResponseDTO> getProductRatesByProductId(String productId) {
        return productRepository.findById(productId)
                .switchIfEmpty(Mono.defer(() -> {
                    log.warn("Product with id {} not found", productId);
                    return Mono.error(new NotFoundException("Product with id " + productId + " not found"));
                }))
                .flatMapMany(product -> productRateRepository.findByProductId(product.getId())
                        .mapNotNull(mapper::productRateToProductRateResponseDTO))
                .switchIfEmpty(Flux.defer(() -> {
                    log.warn("No ProductRates found for product with id {}", productId);
                    return Flux.empty();
                }));
    }

    Flux<P_RateResponseDTO> getProductRatesByUserId(String userId) {
        return userRepository.findById(userId)
                .switchIfEmpty(Mono.defer(() -> {
                    log.warn("User with id {} not found", userId);
                    return Mono.error(new NotFoundException("User with id " + userId + " not found"));
                }))
                .flatMapMany(product -> productRateRepository.findByProductId(product.getId())
                        .mapNotNull(mapper::productRateToProductRateResponseDTO))
                .switchIfEmpty(Flux.defer(() -> {
                    log.warn("No ProductRates found for user with id {}", userId);
                    return Flux.empty();
                }));
    }

    Mono<P_RateResponseDTO> getProductRateById(String id) {
        return productRateRepository.findById(id)
                .switchIfEmpty(returnMonoErrorAndLogWarn(id))
                .map(mapper::productRateToProductRateResponseDTO);
    }

    Mono<P_RateResponseDTO> createProductRate(P_RatePostDTO pRate) {
        return productRateRepository
                .save(mapper.productRatePostDTOToProductRate(pRate))
                .map(mapper::productRateToProductRateResponseDTO);
    }

    Mono<P_RateResponseDTO> updateProductRate(String id, P_RatePutDTO pRate) {
        return productRateRepository.findById(id)
                .switchIfEmpty(returnMonoErrorAndLogWarn(id))
                .flatMap(existingRate -> {
                    existingRate.setRate(pRate.getRate());
                    existingRate.setTitle(pRate.getTitle());
                    existingRate.setComment(pRate.getComment());

                    return productRateRepository.save(existingRate);
                }).map(mapper::productRateToProductRateResponseDTO);
    }

    Mono<P_RateResponseDTO> patchProductRate(String id, P_RatePatchDTO pRate) {
        return productRateRepository.findById(id)
                .switchIfEmpty(returnMonoErrorAndLogWarn(id))
                .flatMap(existingRate -> {
                    Optional.ofNullable(pRate.getRate())
                            .ifPresent(existingRate::setRate);

                    Optional.ofNullable(pRate.getTitle())
                            .ifPresent(existingRate::setTitle);

                    Optional.ofNullable(pRate.getComment())
                            .ifPresent(existingRate::setComment);

                    return productRateRepository.save(existingRate);
                }).map(mapper::productRateToProductRateResponseDTO);
    }

    Mono<Void> deleteProductRate(String id) {
        return productRateRepository
                .deleteById(id)
                .switchIfEmpty(Mono.defer(() -> {
                    log.warn("ProductRate with id {} not found", id);
                    return Mono.error(new NotFoundException("ProductRate with id " + id + " not found"));
                }));
    }
}
