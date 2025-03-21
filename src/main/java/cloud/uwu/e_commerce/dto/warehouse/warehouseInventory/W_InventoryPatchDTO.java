package cloud.uwu.e_commerce.dto.warehouse.warehouseInventory;

import cloud.uwu.e_commerce.model.warehouse.W_Item;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class W_InventoryPatchDTO {
    @NotEmpty(message = "'items' field is empty")
    private List<W_Item> items;
}
