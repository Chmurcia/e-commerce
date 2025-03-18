package cloud.uwu.e_commerce.dto.product.productVariant;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class P_VariantPostDTO {
    @NotNull(message = "'parent_id' field is null")
    @JsonProperty("parent_id")
    private String parentId; // relates to an original product

    @NotNull(message = "'child_id' field is null")
    @JsonProperty("child_id")
    private String childId; // relates to a variant of the original product
}
