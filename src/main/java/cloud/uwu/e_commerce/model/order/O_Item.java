package cloud.uwu.e_commerce.model.order;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;

@Document(collection = "o_item")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class O_Item {
    @Id
    private String id;

    @Field("order_id")
    private String orderId;

    @Field("product_id")
    private String productId;

    private Integer amount;

    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime updatedDate;
}
