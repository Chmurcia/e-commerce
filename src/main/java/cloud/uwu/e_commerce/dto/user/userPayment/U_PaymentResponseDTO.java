package cloud.uwu.e_commerce.dto.user.userPayment;

import cloud.uwu.e_commerce.enums.Currency;
import cloud.uwu.e_commerce.enums.PaymentStatus;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class U_PaymentResponseDTO {
    private String id;

    @JsonProperty("user_id")
    private String userId;

    @JsonProperty("order_id")
    private String orderId;

    private BigDecimal amount;

    private Currency currency;

    @JsonProperty("payment_status")
    private PaymentStatus paymentStatus;

    @JsonProperty("created_date")
    private LocalDateTime createdDate;

    @JsonProperty("updated_date")
    private LocalDateTime updatedDate;
}
