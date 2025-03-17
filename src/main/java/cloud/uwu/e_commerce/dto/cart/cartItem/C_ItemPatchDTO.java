package cloud.uwu.e_commerce.dto.cart.cartItem;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class C_ItemPatchDTO {
    @Min(value = 0, message = "'amount' field is below 0")
    private Integer amount;
}
