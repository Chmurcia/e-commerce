package cloud.uwu.e_commerce.dto.warehouse.warehouseItem;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class W_ItemPostDTO {
    @NotNull(message = "'warehouse_id' field is null")
    @JsonProperty("warehouse_id")
    private String warehouseId;

    @NotNull(message = "'product_id' field is null")
    @JsonProperty("product_id")
    private String productId;

    @NotNull(message = "'amount' field is null")
    @Min(value = 1, message = "value of 'amount' field is below 0")
    private Integer amount;
}
