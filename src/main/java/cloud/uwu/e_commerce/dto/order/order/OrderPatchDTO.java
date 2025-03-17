package cloud.uwu.e_commerce.dto.order.order;

import cloud.uwu.e_commerce.enums.OrderStatus;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Digits;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderPatchDTO {
    @Digits(integer = 10, fraction = 2, message = "'total_price' field has invalid format")
    @JsonProperty("total_price")
    private BigDecimal totalPrice;

    @JsonProperty("order_status")
    private OrderStatus orderStatus;
}
