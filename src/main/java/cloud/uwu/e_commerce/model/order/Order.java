package cloud.uwu.e_commerce.model.order;

import cloud.uwu.e_commerce.enums.OrderStatus;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Document(collection = "order")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Order {
    @Id
    private String id;

    @Field("user_id")
    private String userId;

    @DBRef
    private List<O_Item> items;

    @Field("total_price")
    private BigDecimal totalPrice;

    @Field("order_status")
    private OrderStatus orderStatus;

    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime updatedDate;
}
