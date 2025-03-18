package cloud.uwu.e_commerce.dto.product.productDiscount;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class P_DiscountPutDTO {
    @NotNull(message = "'is_active' field is null")
    @JsonProperty("is_active")
    private Boolean isActive;
}
