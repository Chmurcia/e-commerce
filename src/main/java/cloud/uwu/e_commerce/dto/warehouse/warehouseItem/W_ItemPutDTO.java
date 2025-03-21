package cloud.uwu.e_commerce.dto.warehouse.warehouseItem;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class W_ItemPutDTO {
    @NotNull(message = "'amount' field is null")
    @Min(value = 1, message = "value of 'amount' field is below 0")
    private Integer amount;
}
