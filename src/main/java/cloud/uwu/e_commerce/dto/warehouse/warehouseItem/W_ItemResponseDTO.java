package cloud.uwu.e_commerce.dto.warehouse.warehouseItem;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class W_ItemResponseDTO {
    private String id;

    @JsonProperty("warehouse_id")
    private String warehouseId;

    @JsonProperty("product_id")
    private String productId;

    private Integer amount;

    @JsonProperty("created_date")
    private LocalDateTime createdDate;

    @JsonProperty("updated_date")
    private LocalDateTime updatedDate;
}
