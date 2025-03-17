package cloud.uwu.e_commerce.dto.order.orderItem;

import jakarta.validation.constraints.Min;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class O_ItemPatchDTO {
    @Min(value = 0, message = "value of 'amount' field is below 0")
    private Integer amount;
}
