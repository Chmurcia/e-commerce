package cloud.uwu.e_commerce.services.product;

import cloud.uwu.e_commerce.dto.product.product.ProductPatchDTO;
import cloud.uwu.e_commerce.dto.product.product.ProductPostDTO;
import cloud.uwu.e_commerce.dto.product.product.ProductPutDTO;
import cloud.uwu.e_commerce.dto.product.product.ProductResponseDTO;
import cloud.uwu.e_commerce.exceptions.NotFoundException;
import cloud.uwu.e_commerce.mappers.product.ProductMapper;
import cloud.uwu.e_commerce.model.product.Product;
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
public class ProductService {
    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    private final ProductMapper mapper;

    private Mono<? extends Product> returnMonoErrorAndLogWarn(String id) {
        log.warn("Product with id {} not found", id);
        return Mono.error(new NotFoundException("Product with id " + id + " not found"));
    }

    public Flux<ProductResponseDTO> getAllProducts() {
        return productRepository.findAll()
                .map(mapper::productToProductResponseDTO);
    }

    public Flux<ProductResponseDTO> getProductsByUserId(String userId) {
        return userRepository.findById(userId)
                .switchIfEmpty(Mono.defer(() -> {
                    log.warn("User with id {} not found", userId);
                    return Mono.error(new NotFoundException("User with id " + userId + " not found"));
                }))
                .flatMapMany(user -> productRepository.findBySellerId(userId))
                .mapNotNull(mapper::productToProductResponseDTO);
    }

    public Flux<ProductResponseDTO> getProductsByName(String name) {
        return productRepository.findByName(name)
                .mapNotNull(mapper::productToProductResponseDTO);
    }

    public Mono<ProductResponseDTO> getProductById(String id) {
        return productRepository.findById(id)
                .switchIfEmpty(returnMonoErrorAndLogWarn(id))
                .map(mapper::productToProductResponseDTO);
    }

    public Mono<ProductResponseDTO> createProduct(ProductPostDTO product) {
        return productRepository
                .save(mapper.productPostDTOToProduct(product))
                .map(mapper::productToProductResponseDTO);
    }

    public Mono<ProductResponseDTO> updateProduct(String id, ProductPutDTO product) {
        return productRepository.findById(id)
                .switchIfEmpty(returnMonoErrorAndLogWarn(id))
                .flatMap(existingProduct -> {
                    existingProduct.setName(product.getName());
                    existingProduct.setDescription(product.getDescription());
                    existingProduct.setPrice(product.getPrice());
                    existingProduct.setQuantity(product.getQuantity());
                    existingProduct.setSold(product.getSold());
                    existingProduct.setImageUrl(product.getImageUrl());

                    return productRepository.save(existingProduct);
                })
                .map(mapper::productToProductResponseDTO);
    }

    public Mono<ProductResponseDTO> patchProduct(String id, ProductPatchDTO product) {
        return productRepository.findById(id)
                .switchIfEmpty(returnMonoErrorAndLogWarn(id))
                .flatMap(existingProduct -> {
                    Optional.ofNullable(product.getName())
                        .ifPresent(existingProduct::setName);

                    Optional.ofNullable(product.getDescription())
                            .ifPresent(existingProduct::setDescription);

                    Optional.ofNullable(product.getPrice())
                            .ifPresent(existingProduct::setPrice);

                    Optional.ofNullable(product.getQuantity())
                            .ifPresent(existingProduct::setQuantity);

                    Optional.ofNullable(product.getSold())
                            .ifPresent(existingProduct::setSold);

                    Optional.ofNullable(product.getImageUrl())
                            .ifPresent(existingProduct::setImageUrl);


                    return productRepository.save(existingProduct);
                })
                .map(mapper::productToProductResponseDTO);
    }

    public Mono<Void> deleteProduct(String id) {
        return productRepository
                .deleteById(id)
                .switchIfEmpty(Mono.defer(() -> {
                    log.warn("Product with id {} not found", id);
                    return Mono.error(new NotFoundException("Product with id " + id + " not found"));
                }));
    }


}
