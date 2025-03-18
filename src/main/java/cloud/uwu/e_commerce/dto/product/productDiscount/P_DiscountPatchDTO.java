package cloud.uwu.e_commerce.dto.product.productDiscount;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class P_DiscountPatchDTO {
    @JsonProperty("is_active")
    private Boolean isActive;
}
