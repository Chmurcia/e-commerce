package cloud.uwu.e_commerce.dto.wishlist.wishlist;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WishlistPutDTO {
    @NotNull(message = "'total_amount' field is null")
    @Min(value = 0, message = "value of 'total_amount' field is below 0")
    @JsonProperty("total_amount")
    private Integer totalAmount;
}
