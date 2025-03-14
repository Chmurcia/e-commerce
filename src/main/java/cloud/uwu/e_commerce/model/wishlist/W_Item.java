package cloud.uwu.e_commerce.model.wishlist;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;

@Document(collection = "w_item")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class W_Item {
    @Id
    private String id;

    @Field("wishlist_id")
    private String wishlistId;

    @Field("product_id")
    private String productId;

    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime updatedDate;
}
