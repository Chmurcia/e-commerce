package cloud.uwu.e_commerce.dto.warehouse.warehouse;

import cloud.uwu.e_commerce.model.product.Product;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WarehouseResponseDTO {
    private String id;

    @JsonProperty("user_id")
    private String userId;

    private String name;

    private List<Product> products;

    @JsonProperty("created_date")
    private LocalDateTime createdDate;

    @JsonProperty("updated_date")
    private LocalDateTime updatedDate;
}
