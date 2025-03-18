package cloud.uwu.e_commerce.dto.product.productSalesReport;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class P_Sales_ReportResponseDTO {
    private String id;

    @JsonProperty("product_id")
    private String productId;

    @JsonProperty("units_sold")
    private Integer unitsSold;

    private BigDecimal revenue;

    private Integer returns;

    private BigDecimal refunds;

    @JsonProperty("created_date")
    private LocalDateTime createdDate;

    @JsonProperty("updated_date")
    private LocalDateTime updatedDate;
}
