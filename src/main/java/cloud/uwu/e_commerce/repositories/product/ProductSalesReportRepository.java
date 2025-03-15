package cloud.uwu.e_commerce.repositories.product;

import cloud.uwu.e_commerce.model.product.P_Sales_Report;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ProductSalesReportRepository extends ReactiveMongoRepository<P_Sales_Report, String> {
}
