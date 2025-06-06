package cloud.uwu.e_commerce.model.warehouse;

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

    @Field("warehouse_id")
    private String warehouseId;

    @Field("product_id")
    private String productId;

    private Integer amount;

    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime updatedDate;
}
