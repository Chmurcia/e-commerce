package cloud.uwu.e_commerce.model.product;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "rate")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Rate {
    @Id
    private String id;

    private Double rate;

    private String title;

    private String comment;

    private String userId;

    private String productId;

    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime UpdatedDate;
}
