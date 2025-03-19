package cloud.uwu.e_commerce.dto.user.userRefund;

import cloud.uwu.e_commerce.enums.ReturnStatus;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class U_ReturnPostDTO {
    @NotNull(message = "'user_id' field is null")
    @JsonProperty("user_id")
    private String userId;

    @NotNull(message = "'order_id' field is null")
    @JsonProperty("order_id")
    private String orderId;

    @NotNull(message = "'product_id' field is null")
    @JsonProperty("product_id")
    private String productId;

    @NotNull(message = "'quantity' field is null")
    @Min(value = 1, message = "value of 'quantity' field is below 1")
    private Integer quantity;

    @NotBlank(message = "'return_reason' field is null")
    @Size(min = 1, max = 1000, message = "length of 'return_reason' field must be between 1 and 1000 characters")
    @JsonProperty("return_reason")
    private String returnReason;

    @NotNull(message = "'return_status' field is null")
    @JsonProperty("return_status")
    private ReturnStatus returnStatus;
}
