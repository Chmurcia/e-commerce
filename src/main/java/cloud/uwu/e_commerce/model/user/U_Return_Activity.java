package cloud.uwu.e_commerce.model.user;

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
public class U_Return_Activity {
    @Id
    private String id;

    @Field("user_id")
    private String userId;

    @Field("return_id")
    private String returnId;

    private String title;

    private String description;

    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime updatedDate;
}
