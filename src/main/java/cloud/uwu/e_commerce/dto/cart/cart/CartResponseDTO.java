package cloud.uwu.e_commerce.dto.cart.cart;

import cloud.uwu.e_commerce.enums.Currency;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CartResponseDTO {
    private String id;

    @JsonProperty("user_id")
    private String userId;

    @JsonProperty("total_amount")
    private Integer totalAmount;

    @JsonProperty("total_price")
    private BigDecimal totalPrice;

    private Currency currency;

    @JsonProperty("created_date")
    private LocalDateTime createdDate;

    @JsonProperty("updated_date")
    private LocalDateTime updatedDate;
}
