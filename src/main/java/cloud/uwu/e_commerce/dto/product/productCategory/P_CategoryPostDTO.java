package cloud.uwu.e_commerce.dto.product.productCategory;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class P_CategoryPostDTO {
    @NotNull(message = "'product_id' field is null")
    @JsonProperty("product_id")
    private String productId;

    @NotNull(message = "'category_id' field is null")
    @JsonProperty("category_id")
    private String categoryId;
}
