package cloud.uwu.e_commerce.dto.user.userRefund;

import cloud.uwu.e_commerce.enums.Currency;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class U_RefundPostDTO {
    @NotNull(message = "'user_id' field is null")
    @JsonProperty("user_id")
    private String userId;

    @NotNull(message = "'return_id' field is null")
    @JsonProperty("return_id")
    private String returnId;

    @NotNull(message = "'order_id' field is null")
    @JsonProperty("order_id")
    private String orderId;

    @NotNull(message = "'amount' field is null")
    @DecimalMin(value = "0.0", message = "value of 'amount' field is below 0")
    private BigDecimal amount;

    @NotNull(message = "'currency' field is null")
    private Currency currency;
}
