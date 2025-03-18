package cloud.uwu.e_commerce.dto.product.productTag;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class P_TagResponseDTO {
    private String id;

    @JsonProperty("product_id")
    private String productId;

    private String tag;

    @JsonProperty("created_date")
    private LocalDateTime createdDate;

    @JsonProperty("updated_date")
    private LocalDateTime updatedDate;
}
