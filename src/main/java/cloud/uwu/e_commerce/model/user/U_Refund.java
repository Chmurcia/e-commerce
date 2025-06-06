package cloud.uwu.e_commerce.model.user;

import cloud.uwu.e_commerce.enums.Currency;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Document(collection = "u_refund")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class U_Refund {
    @Id
    private String id;

    @Field("user_id")
    private String userId;

    @Field("return_id")
    private String returnId;

    @Field("order_id")
    private String orderId;

    private BigDecimal amount;

    private Currency currency;

    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime updatedDate;
}
