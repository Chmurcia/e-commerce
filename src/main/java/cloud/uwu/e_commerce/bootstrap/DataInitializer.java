package cloud.uwu.e_commerce.bootstrap;

import cloud.uwu.e_commerce.model.product.Product;
import cloud.uwu.e_commerce.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {
        productRepository.count()
                .flatMap(count -> {
                    if (count == 0) {
                        return productRepository.saveAll(createProducts()).then();
                    }
                    return Mono.empty();
                })
                .then()
                .doOnTerminate(() -> System.out.println("Product data has been successfully loaded to the database."))
                .subscribe();

    }

    private Iterable<Product> createProducts() {
        Product product1 = Product.builder()
                .name("Coffee")
                .description("Delicious coffee made from high-quality beans.")
                .price(BigDecimal.valueOf(24.99))
                .quantity(187)
                .sold(14)
                .sellerId("123")
                .imageUrl("https://example.com/coffee.jpg")
                .createdDate(LocalDateTime.now())
                .updatedDate(LocalDateTime.now())
                .build();

        Product product2 = Product.builder()
                .name("Tea")
                .description("Freshly brewed tea from the finest leaves.")
                .price(BigDecimal.valueOf(3.99))
                .quantity(1487)
                .sold(811)
                .sellerId("771")
                .imageUrl("https://example.com/tea.jpg")
                .createdDate(LocalDateTime.now())
                .updatedDate(LocalDateTime.now())
                .build();

        return List.of(product1, product2);
    }
}
