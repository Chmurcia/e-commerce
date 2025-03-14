package cloud.uwu.e_commerce.model.product;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;

@Document(collection = "p_discount")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class P_Discount {
    @Id
    private String id;

    @Field("product_id")
    private String productId;

    @Field("discount_id")
    private String discountId;

    @Field("is_active")
    private Boolean isActive;

    @Field("start_date")
    private LocalDateTime startDate;

    @Field("end_date")
    private LocalDateTime endDate;

    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime updatedDate;
}
