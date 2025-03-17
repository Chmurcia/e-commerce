package cloud.uwu.e_commerce.dto.cart.cartItem;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class C_ItemResponseDTO {
    private String id;

    @JsonProperty("cart_id")
    private String cartId;

    @JsonProperty("product_id")
    private String productId;

    private Integer amount;

    @JsonProperty("created_date")
    private LocalDateTime createdDate;

    @JsonProperty("updated_date")
    private LocalDateTime updatedDate;
}
