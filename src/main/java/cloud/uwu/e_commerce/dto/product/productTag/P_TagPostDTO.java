package cloud.uwu.e_commerce.dto.product.productTag;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class P_TagPostDTO {
    @NotNull(message = "'product_id' field is null")
    @JsonProperty("product_id")
    private String productId;

    @NotBlank(message = "'tag' field is null")
    @Size(min = 1, max = 50, message = "length of 'tag' field must be between 1 and 50")
    private String tag;
}
