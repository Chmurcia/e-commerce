package cloud.uwu.e_commerce.dto.order.order;

import cloud.uwu.e_commerce.dto.order.orderItem.O_ItemResponseDTO;
import cloud.uwu.e_commerce.enums.OrderStatus;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderResponseDTO {
    private String id;

    @JsonProperty("user_id")
    private String userId;

    private List<O_ItemResponseDTO> items;

    @JsonProperty("total_price")
    private BigDecimal totalPrice;

    @JsonProperty("order_status")
    private OrderStatus orderStatus;

    @JsonProperty("created_date")
    private LocalDateTime createdDate;

    @JsonProperty("updated_date")
    private LocalDateTime updatedDate;
}
