package cloud.uwu.e_commerce.dto.product.productMultimedia;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class P_MultimediaResponseDTO {
    private String id;

    @JsonProperty("multimedia_url")
    private String multimediaUrl;

    @JsonProperty("product_id")
    private String productId;

    @JsonProperty("created_date")
    private LocalDateTime createdDate;

    @JsonProperty("updated_date")
    private LocalDateTime updatedDate;
}
