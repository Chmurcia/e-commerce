package cloud.uwu.e_commerce.model.cart;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;

@Document(collection = "c_item")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class C_Item {
    @Id
    private String id;

    @Field("cart_id")
    private String cartId;

    @Field("product_id")
    private String productId;

    private Integer amount;

    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime updatedDate;
}
