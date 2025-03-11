package cloud.uwu.e_commerce.model.product;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Document(collection = "p_sales_report")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class P_Sales_Report {
    @Id
    private String id;

    private String productId;

    private Integer unitsSold;

    private BigDecimal revenue;

    private Integer returns;

    private BigDecimal refunds;

    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime updatedDate;
}
