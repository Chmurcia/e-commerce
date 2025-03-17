package cloud.uwu.e_commerce.dto.order.orderItem;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class O_ItemPutDTO {
    @NotNull(message = "'amount' field is null")
    @Min(value = 0, message = "value of 'amount' field is below 0")
    private Integer amount;
}
