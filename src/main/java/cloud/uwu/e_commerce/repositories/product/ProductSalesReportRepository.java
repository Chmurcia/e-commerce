package cloud.uwu.e_commerce.repositories.product;

import cloud.uwu.e_commerce.model.product.P_Sales_Report;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface ProductSalesReportRepository extends ReactiveMongoRepository<P_Sales_Report, String> {
    Flux<P_Sales_Report> findByProductId(String productId);
}
