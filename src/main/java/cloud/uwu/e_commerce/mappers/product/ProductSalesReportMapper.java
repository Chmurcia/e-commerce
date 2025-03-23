package cloud.uwu.e_commerce.mappers.product;

import cloud.uwu.e_commerce.dto.product.productSalesReport.P_Sales_ReportPostDTO;
import cloud.uwu.e_commerce.dto.product.productSalesReport.P_Sales_ReportResponseDTO;
import cloud.uwu.e_commerce.model.product.P_Sales_Report;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductSalesReportMapper {
    P_Sales_Report productSalesReportPostDTOToProductSalesReport(P_Sales_ReportPostDTO pSalesReportPostDTO);

    P_Sales_ReportResponseDTO productSalesReportToProductSalesReportResponseDTO(P_Sales_Report pSalesReport);
}
