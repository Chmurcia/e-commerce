package cloud.uwu.e_commerce.dto.product.productMultimedia;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class P_MultimediaPostDTO {
    @NotBlank(message = "'multimedia_url' field is null")
    @JsonProperty("multimedia_url")
    private String multimediaUrl;

    @NotNull(message = "'product_id' field is null")
    @JsonProperty("product_id")
    private String productId;
}
