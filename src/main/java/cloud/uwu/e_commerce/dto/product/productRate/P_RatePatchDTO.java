package cloud.uwu.e_commerce.dto.product.productRate;

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
public class P_RatePatchDTO {
    @Min(value = 0, message = "value of 'rate' field is below 0")
    private Double rate;

    @Size(max = 100, message = "length of 'title' field must be between 0 and 100")
    private String title;

    @Size(max = 500, message = "length of 'comment' field must be between 0 and 500")
    private String comment;
}
