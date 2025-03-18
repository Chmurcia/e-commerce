package cloud.uwu.e_commerce.dto.product.productDiscount;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class P_DiscountPostDTO {
    @NotNull(message = "'product_id' field is null")
    @JsonProperty("product_id")
    private String productId;

    @NotNull(message = "'discount_id' field is null")
    @JsonProperty("discount_id")
    private String discountId;

    @NotNull(message = "'is_active' field is null")
    @JsonProperty("is_active")
    private Boolean isActive;

    @NotNull(message = "'start_date' field is null")
    @Future(message = "'start_date' must be in future")
    @JsonProperty("start_date")
    private LocalDateTime startDate;

    @NotNull(message = "'end_date' field is null")
    @Future(message = "'end_date' must be in future")
    @JsonProperty("end_date")
    private LocalDateTime endDate;
}
