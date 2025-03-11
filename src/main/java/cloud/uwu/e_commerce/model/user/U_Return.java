package cloud.uwu.e_commerce.model.user;

import cloud.uwu.e_commerce.enums.ReturnStatus;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

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

    private String userId;

    private String orderId;

    private String productId;

    private Integer quantity;

    private String returnReason;

    private ReturnStatus returnStatus;

    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime updatedDate;
}
