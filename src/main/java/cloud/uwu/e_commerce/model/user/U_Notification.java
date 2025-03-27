package cloud.uwu.e_commerce.model.user;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;

@Document(collection = "u_notification")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class U_Notification {
    @Id
    private String id;

    @Field("user_id")
    private String userId;

    private String title;

    private String description;

    @Field("related_to")
    private String relatedTo;

    @Field("related_id")
    private String relatedId;

    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime updatedDate;
}
