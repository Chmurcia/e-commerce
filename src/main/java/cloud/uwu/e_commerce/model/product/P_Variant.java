package cloud.uwu.e_commerce.model.product;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "p_variant")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class P_Variant {
    @Id
    private String id;

    private String parentId; // relates to an original product

    private String childId; // relates to a variant of the original product

    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime updatedDate;
}
