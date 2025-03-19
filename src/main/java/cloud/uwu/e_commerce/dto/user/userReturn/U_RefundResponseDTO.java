package cloud.uwu.e_commerce.dto.user.userReturn;

import cloud.uwu.e_commerce.enums.Currency;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class U_RefundResponseDTO {
    private String id;

    @JsonProperty("user_id")
    private String userId;

    @JsonProperty("return_id")
    private String returnId;

    @JsonProperty("order_id")
    private String orderId;

    private BigDecimal amount;

    private Currency currency;

    @JsonProperty("created_date")
    private LocalDateTime createdDate;

    @JsonProperty("updated_date")
    private LocalDateTime updatedDate;
}
