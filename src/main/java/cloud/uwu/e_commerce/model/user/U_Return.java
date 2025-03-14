package cloud.uwu.e_commerce.model.user;

import cloud.uwu.e_commerce.enums.ReturnStatus;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;

@Document(collection = "u_return")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class U_Return {
    @Id
    private String id;

    @Field("user_id")
    private String userId;

    @Field("order_id")
    private String orderId;

    @Field("product_id")
    private String productId;

    private Integer quantity;

    @Field("return_reason")
    private String returnReason;

    @Field("return_status")
    private ReturnStatus returnStatus;

    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime updatedDate;
}
