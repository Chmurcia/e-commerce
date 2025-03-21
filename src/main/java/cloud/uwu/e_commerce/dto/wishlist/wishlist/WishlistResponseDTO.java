package cloud.uwu.e_commerce.dto.wishlist.wishlist;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WishlistResponseDTO {
    private String id;

    @JsonProperty("user_id")
    private String userId;

    @JsonProperty("total_amount")
    private Integer totalAmount;

    @JsonProperty("created_date")
    private LocalDateTime createdDate;

    @JsonProperty("updated_date")
    private LocalDateTime updatedDate;
}
