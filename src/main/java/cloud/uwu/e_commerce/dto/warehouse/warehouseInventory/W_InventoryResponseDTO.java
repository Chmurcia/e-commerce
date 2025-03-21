package cloud.uwu.e_commerce.dto.warehouse.warehouseInventory;

import cloud.uwu.e_commerce.model.warehouse.W_Item;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class W_InventoryResponseDTO {
    private String id;

    @JsonProperty("warehouse_id")
    private String warehouseId;

    private List<W_Item> items;

    @JsonProperty("created_date")
    private LocalDateTime createdDate;

    @JsonProperty("updated_date")
    private LocalDateTime updatedDate;
}
