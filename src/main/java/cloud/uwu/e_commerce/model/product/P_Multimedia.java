package cloud.uwu.e_commerce.model.product;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "p_multimedia")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class P_Multimedia {
    @Id
    private String id;

    private String multimediaUrl;

    private String productId;

    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime updatedDate;
}
