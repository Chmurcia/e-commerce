package cloud.uwu.e_commerce.dto.product.productSalesReport;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class P_Sales_ReportPostDTO {
    @NotNull(message = "'product_id' field is null")
    @JsonProperty("product_id")
    private String productId;

    @NotNull(message = "'units_sold' field is null")
    @Min(value = 0, message = "'units_sold' field is below 0")
    @JsonProperty("units_sold")
    private Integer unitsSold;

    @NotNull(message = "'total_revenue' field is null")
    @DecimalMin(value = "0.0", message = "value of 'total_revenue' field is below 0")
    @Digits(integer = 10, fraction = 2, message = "'total_revenue' field has invalid format")
    @JsonProperty("total_revenue")
    private BigDecimal totalRevenue;

    @NotNull(message = "'returns' field is null")
    @Min(value = 0, message = "'returns' field is below 0")
    private Integer returns;

    @NotNull(message = "'total_refunds' field is null")
    @DecimalMin(value = "0.0", message = "value of 'total_refunds' field is below 0")
    @Digits(integer = 10, fraction = 2, message = "'total_refunds' field has invalid format")
    @JsonProperty("total_refunds")
    private BigDecimal totalRefunds;
}
