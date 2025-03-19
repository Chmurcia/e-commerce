package cloud.uwu.e_commerce.dto.user.userPayment;

import cloud.uwu.e_commerce.enums.Currency;
import cloud.uwu.e_commerce.enums.PaymentStatus;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class U_PaymentPostDTO {
    @NotNull(message = "'user_id' field is null")
    @JsonProperty("user_id")
    private String userId;

    @NotNull(message = "'order_id' field is null")
    @JsonProperty("order_id")
    private String orderId;

    @NotNull(message = "'amount' field is null")
    @DecimalMin(value = "0.0", message = "value of 'amount' field is below 0")
    @Digits(integer = 10, fraction = 2, message = "'amount' field has invalid format")
    private BigDecimal amount;

    @NotNull(message = "'currency' field is null")
    private Currency currency;

    @NotNull(message = "'payment_status' field is null")
    @JsonProperty("payment_status")
    private PaymentStatus paymentStatus;
}
