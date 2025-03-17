package cloud.uwu.e_commerce.dto.order.order;

import cloud.uwu.e_commerce.enums.OrderStatus;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderPutDTO {
    @NotNull(message = "'total_price' field is null")
    @Digits(integer = 10, fraction = 2, message = "'total_price' field has invalid format")
    @JsonProperty("total_price")
    private BigDecimal totalPrice;

    @NotNull(message = "'order_status' field is null")
    @JsonProperty("order_status")
    private OrderStatus orderStatus;
}
