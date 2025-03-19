package cloud.uwu.e_commerce.dto.user.userNotification;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class U_NotificationResponseDTO {
    private String id;

    private String title;

    private String description;

    @JsonProperty("related_to")
    private String relatedTo;

    @JsonProperty("related_id")
    private String relatedId;

    @JsonProperty(namespace = "created_date")
    private LocalDateTime createdDate;

    @JsonProperty(namespace = "updated_date")
    private LocalDateTime updatedDate;
}
