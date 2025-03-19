package cloud.uwu.e_commerce.dto.user.userRefund;

import cloud.uwu.e_commerce.enums.ReturnStatus;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class U_ReturnResponseDTO {
    private String id;

    @JsonProperty("user_id")
    private String userId;

    @JsonProperty("order_id")
    private String orderId;

    @JsonProperty("product_id")
    private String productId;

    private Integer quantity;

    @JsonProperty("return_reason")
    private String returnReason;

    @JsonProperty("return_status")
    private ReturnStatus returnStatus;

    @JsonProperty("created_date")
    private LocalDateTime createdDate;

    @JsonProperty("updated_date")
    private LocalDateTime updatedDate;
}
