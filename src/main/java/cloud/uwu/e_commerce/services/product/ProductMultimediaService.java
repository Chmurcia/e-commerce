package cloud.uwu.e_commerce.services.product;

import cloud.uwu.e_commerce.dto.product.productMultimedia.P_MultimediaPostDTO;
import cloud.uwu.e_commerce.dto.product.productMultimedia.P_MultimediaResponseDTO;
import cloud.uwu.e_commerce.exceptions.NotFoundException;
import cloud.uwu.e_commerce.mappers.product.ProductMultimediaMapper;
import cloud.uwu.e_commerce.repositories.product.ProductMultimediaRepository;
import cloud.uwu.e_commerce.repositories.product.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductMultimediaService {
    private final ProductRepository productRepository;
    private final ProductMultimediaRepository productMultimediaRepository;
    private final ProductMultimediaMapper mapper;

    Flux<P_MultimediaResponseDTO> getProductMultimediaByProductId(String productId) {
        return productRepository.findById(productId)
                .switchIfEmpty(Mono.defer(() -> {
                    log.warn("Product with id {} not found", productId);
                    return Mono.error(new NotFoundException("Product with id "+ productId + " not found"));
                }))
                .flatMapMany(product -> productMultimediaRepository.findByProductId(product.getId())
                        .mapNotNull(mapper::productMultimediaToProductMultimediaResponseDTO))
                .switchIfEmpty(Flux.defer(() -> {
                    log.warn("No ProductMultimedia found for product with id {}", productId);
                    return Flux.empty();
                }));
    }

    Mono<P_MultimediaResponseDTO> getProductMultimediaById(String id) {
        return productMultimediaRepository.findById(id)
                .switchIfEmpty(Mono.defer(() -> {
                    log.warn("ProductMultimedia with id {} not found", id);
                    return Mono.error(new NotFoundException("ProductMultimedia with id " + id + " not found"));
                }))
                .map(mapper::productMultimediaToProductMultimediaResponseDTO);
    }

    Mono<P_MultimediaResponseDTO> createProductMultimedia(P_MultimediaPostDTO pMultimedia) {
        return productMultimediaRepository
                .save(mapper.productMultimediaPostDTOToProductMultimedia(pMultimedia))
                .map(mapper::productMultimediaToProductMultimediaResponseDTO);
    }

    Mono<Void> deleteProductMultimedia(String id) {
        return productMultimediaRepository
                .deleteById(id)
                .switchIfEmpty(Mono.defer(() -> {
                    log.warn("ProductMultimedia with id {} not found", id);
                    return Mono.error(new NotFoundException("ProductMultimedia with id " + id + " not found"));
                }));
    }
}
