package cloud.uwu.e_commerce.services.product;

import cloud.uwu.e_commerce.dto.product.productSalesReport.P_Sales_ReportPostDTO;
import cloud.uwu.e_commerce.dto.product.productSalesReport.P_Sales_ReportResponseDTO;
import cloud.uwu.e_commerce.exceptions.NotFoundException;
import cloud.uwu.e_commerce.mappers.product.ProductSalesReportMapper;
import cloud.uwu.e_commerce.repositories.product.ProductRepository;
import cloud.uwu.e_commerce.repositories.product.ProductSalesReportRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductSalesReportService {
    private ProductRepository productRepository;
    private ProductSalesReportRepository productSalesReportRepository;
    private ProductSalesReportMapper mapper;

    Flux<P_Sales_ReportResponseDTO> getProductSalesReportByProductId(String productId) {
        return productRepository.findById(productId)
                .switchIfEmpty(Mono.defer(() -> {
                    log.warn("Product with id {} not found", productId);
                    return Mono.error(new NotFoundException("Product with id "+ productId + " not found"));
                }))
                .flatMapMany(product -> productSalesReportRepository.findByProductId(product.getId())
                        .mapNotNull(mapper::productSalesReportToProductSalesReportResponseDTO))
                .switchIfEmpty(Flux.defer(() -> {
                    log.warn("No ProductSalesReports found for product with id {}", productId);
                    return Flux.empty();
                }));
    }

    Mono<P_Sales_ReportResponseDTO> getProductSalesReportById(String id) {
        return productSalesReportRepository.findById(id)
                .switchIfEmpty(Mono.defer(() -> {
                    log.warn("ProductSalesReport with id {} not found", id);
                    return Mono.error(new NotFoundException("ProductSalesReport with id "+ id + " not found"));
                }))
                .map(mapper::productSalesReportToProductSalesReportResponseDTO);
    }

    Mono<P_Sales_ReportResponseDTO> createProductSalesReport(P_Sales_ReportPostDTO pSalesReport) {
        return productSalesReportRepository
                .save(mapper.productSalesReportPostDTOToProductSalesReport(pSalesReport))
                .map(mapper::productSalesReportToProductSalesReportResponseDTO);
    }

    Mono<Void> deleteProductReport(String id) {
        return productSalesReportRepository
                .deleteById(id)
                .switchIfEmpty(Mono.defer(() -> {
                    log.warn("ProductSalesReport with id {} not found", id);
                    return Mono.error(new NotFoundException("ProductSalesReport with id "+ id + " not found"));
                }));
    }
}
