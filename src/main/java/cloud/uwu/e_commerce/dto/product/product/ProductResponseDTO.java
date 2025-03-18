package cloud.uwu.e_commerce.dto.product.product;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductResponseDTO {
    private String id;

    private String name;

    private String description;

    private BigDecimal price;

    private Integer quantity;

    private Integer sold;

    @JsonProperty("seller_id")
    private String sellerId;

    @JsonProperty("image_url")
    private String imageUrl;

    @JsonProperty("created_date")
    private LocalDateTime createdDate;

    @JsonProperty("updated_date")
    private LocalDateTime updatedDate;
}
