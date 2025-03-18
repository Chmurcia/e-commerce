package cloud.uwu.e_commerce.dto.product.productRate;

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
public class P_RatePostDTO {
    @NotNull(message = "'rate' field is null")
    @Min(value = 0, message = "value of 'rate' field is below 0")
    private Double rate;

    @NotBlank(message = "'title' field is null")
    @Size(min = 1, max = 100, message = "length of 'title' field must be between 1 and 100")
    private String title;

    @NotBlank(message = "'comment' field is null")
    @Size(min = 1, max = 500, message = "length of 'comment' field must be between 1 and 500")
    private String comment;

    @NotNull(message = "'user_id' field is null")
    @JsonProperty("user_id")
    private String userId;

    @NotNull(message = "'product_id' field is null")
    @JsonProperty("product_id")
    private String productId;
}
