package cloud.uwu.e_commerce.dto.product.productVariant;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDateTime;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class P_VariantResponseDTO {
    private String id;

    @JsonProperty("parent_id")
    private String parentId; // relates to an original product

    @JsonProperty("child_id")
    private String childId; // relates to a variant of the original product

    @JsonProperty("created_date")
    private LocalDateTime createdDate;

    @JsonProperty("updated_date")
    private LocalDateTime updatedDate;
}
