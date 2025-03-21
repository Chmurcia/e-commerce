package cloud.uwu.e_commerce.dto.wishlist.wishlistItem;

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

    @JsonProperty("wishlist_id")
    private String wishlistId;

    @JsonProperty("product_id")
    private String productId;

    @JsonProperty("created_date")
    private LocalDateTime createdDate;

    @JsonProperty("updated_date")
    private LocalDateTime updatedDate;
}
