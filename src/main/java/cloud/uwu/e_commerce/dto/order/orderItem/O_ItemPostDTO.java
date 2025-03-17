package cloud.uwu.e_commerce.dto.order.orderItem;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class O_ItemPostDTO {
    @NotNull(message = "'order_id' field is null")
    @JsonProperty("order_id")
    private String orderId;

    @NotNull(message = "'product_id' field is null")
    @JsonProperty("product_id")
    private String productId;

    @NotNull(message = "'amount' field is null")
    @Min(value = 0, message = "value of 'amount' field is below 0")
    private Integer amount;
}
