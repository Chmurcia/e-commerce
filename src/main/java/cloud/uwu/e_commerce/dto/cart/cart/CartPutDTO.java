package cloud.uwu.e_commerce.dto.cart.cart;

import cloud.uwu.e_commerce.enums.Currency;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CartPutDTO {
    @NotNull(message = "'total_amount' field is null")
    @Min(value = 0, message = "value of 'total_amount' field is below 0")
    @JsonProperty("total_amount")
    private Integer totalAmount;

    @NotNull(message = "'total_price' field is null")
    @DecimalMin(value = "0.0", message = "value of 'total_price' field is below 0")
    @Digits(integer = 10, fraction = 2, message = "'total_price' field has invalid format")
    @JsonProperty("total_price")
    private BigDecimal totalPrice;

    @NotNull(message = "'currency' field is null")
    private Currency currency;
}
