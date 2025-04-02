package cloud.uwu.e_commerce.services.product;

import cloud.uwu.e_commerce.dto.product.productCategory.P_CategoryPostDTO;
import cloud.uwu.e_commerce.dto.product.productCategory.P_CategoryResponseDTO;
import cloud.uwu.e_commerce.exceptions.NotFoundException;
import cloud.uwu.e_commerce.mappers.product.ProductCategoryMapper;
import cloud.uwu.e_commerce.model.product.P_Category;
import cloud.uwu.e_commerce.repositories.product.ProductCategoryRepository;
import cloud.uwu.e_commerce.repositories.product.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductCategoryService {
    private final ProductRepository productRepository;
    private final ProductCategoryRepository productCategoryRepository;
    private final ProductCategoryMapper mapper;

    public Flux<P_CategoryResponseDTO> getProductCategoriesByProductId(String productId) {
        return productRepository.findById(productId)
                .switchIfEmpty(Mono.defer(() -> {
                    log.warn("Product with id {} not found", productId);
                    return Mono.error(new NotFoundException("Product with id " + productId + " not found"));
                }))
                .flatMapMany(product -> productCategoryRepository
                        .findByProductId(product.getId()))
                        .mapNotNull(mapper::productCategoryToProductCategoryResponseDTO)
                .switchIfEmpty(Flux.defer(() -> {
                    log.warn("No ProductCategories found for product with id {}", productId);
                    return Flux.empty();
                }));
    }

    public Mono<P_CategoryResponseDTO> getProductCategoryById(String id) {
        return productCategoryRepository.findById(id)
                .switchIfEmpty(Mono.defer(() -> {
                    log.warn("ProductCategory with id {} not found", id);
                    return Mono.error(new NotFoundException("ProductCategory with id " + id + " not found"));
                }))
                .map(mapper::productCategoryToProductCategoryResponseDTO);
    }

    public Mono<P_CategoryResponseDTO> createProductCategory(P_CategoryPostDTO pCategory) {
        return productCategoryRepository
                .save(mapper.productCategoryPostDTOToProductCategory(pCategory))
                .map(mapper::productCategoryToProductCategoryResponseDTO);
    }

    public Mono<Void> deleteProductCategory(String id) {
        return productCategoryRepository.deleteById(id)
                .switchIfEmpty(Mono.defer(() -> {
                    log.warn("ProductCategory with id {} not found", id);
                    return Mono.error(new NotFoundException("ProductCategory with id " + id + " not found"));
                }));
    }
}