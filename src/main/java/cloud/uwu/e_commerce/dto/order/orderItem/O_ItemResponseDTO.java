package cloud.uwu.e_commerce.dto.order.orderItem;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class O_ItemResponseDTO {
    private String id;

    @JsonProperty("order_id")
    private String orderId;

    @JsonProperty("product_id")
    private String productId;

    private Integer amount;

    @JsonProperty("created_date")
    private LocalDateTime createdDate;

    @JsonProperty("updated_date")
    private LocalDateTime updatedDate;
}
