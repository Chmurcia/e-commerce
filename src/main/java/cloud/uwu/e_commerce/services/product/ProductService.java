package cloud.uwu.e_commerce.services.product;

import cloud.uwu.e_commerce.dto.product.product.ProductResponseDTO;
import cloud.uwu.e_commerce.exceptions.NotFoundException;
import cloud.uwu.e_commerce.mappers.product.ProductMapper;
import cloud.uwu.e_commerce.repositories.product.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository repository;
    private final ProductMapper mapper;

    public Mono<ProductResponseDTO> getProductById(String id) {
        return repository.findById(id)
                .map(mapper::productToProductResponseDTO)
                .switchIfEmpty(Mono.error(new NotFoundException("Product with id " + id + " not found")));
    }



}
