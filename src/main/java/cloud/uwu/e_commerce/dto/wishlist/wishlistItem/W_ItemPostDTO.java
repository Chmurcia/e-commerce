package cloud.uwu.e_commerce.dto.wishlist.wishlistItem;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class W_ItemPostDTO {
    @NotNull(message = "'wishlist_id' field is null")
    @JsonProperty("wishlist_id")
    private String wishlistId;

    @NotNull(message = "'product_id' field is null")
    @JsonProperty("product_id")
    private String productId;
}
