package cloud.uwu.e_commerce.services.user;

import cloud.uwu.e_commerce.mappers.product.ProductMapper;
import cloud.uwu.e_commerce.model.product.Product;
import cloud.uwu.e_commerce.repositories.product.ProductRepository;
import cloud.uwu.e_commerce.services.product.ProductService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Mock
    private ProductRepository repository;

    @Mock
    private ProductMapper mapper;

    @InjectMocks
    private ProductService service;

    @Test
    void getProductById_ShouldReturnUserId() {
        String productId = "123";

        Product product = Product.builder()
                .name("product 1")
                .build();
    }
}