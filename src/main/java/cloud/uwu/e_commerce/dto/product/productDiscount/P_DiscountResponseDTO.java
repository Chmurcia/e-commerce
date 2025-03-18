package cloud.uwu.e_commerce.dto.product.productDiscount;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class P_DiscountResponseDTO {
    private String id;

    @JsonProperty("product_id")
    private String productId;

    @JsonProperty("discount_id")
    private String discountId;

    @JsonProperty("is_active")
    private Boolean isActive;

    @JsonProperty("start_date")
    private LocalDateTime startDate;

    @JsonProperty("end_date")
    private LocalDateTime endDate;

    @JsonProperty("created_date")
    private LocalDateTime createdDate;

    @JsonProperty("updated_date")
    private LocalDateTime updatedDate;
}
