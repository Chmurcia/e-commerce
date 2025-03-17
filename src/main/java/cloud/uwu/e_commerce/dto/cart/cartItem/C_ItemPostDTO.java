package cloud.uwu.e_commerce.dto.cart.cartItem;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class C_ItemPostDTO {
    @NotNull(message = "'cart_id' is null")
    @JsonProperty("cart_id")
    private String cartId;

    @NotNull(message = "'product_id' is null")
    @JsonProperty("product_id")
    private String productId;

    @NotNull(message = "'amount' field is null")
    @Min(value = 0, message = "'amount' field is below 0")
    private Integer amount;
}
