package cloud.uwu.e_commerce.model.product;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;

@Document(collection = "p_category")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class P_Category {
    @Id
    private String id;

    @Field("product_id")
    private String productId;

    @Field("category_id")
    private String categoryId;

    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime updatedDate;
}
