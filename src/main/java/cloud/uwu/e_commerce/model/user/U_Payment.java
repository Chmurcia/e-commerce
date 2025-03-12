package cloud.uwu.e_commerce.model.user;

import cloud.uwu.e_commerce.enums.Currency;
import cloud.uwu.e_commerce.enums.PaymentStatus;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Document(collection = "u_payment")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class U_Payment {
    @Id
    private String id;

    private String userId;

    private String orderId;

    private BigDecimal amount;

    private Currency currency;

    private PaymentStatus paymentStatus;

    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime updatedDate;
}
