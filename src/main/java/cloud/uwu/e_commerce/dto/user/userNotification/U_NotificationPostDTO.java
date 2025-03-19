package cloud.uwu.e_commerce.dto.user.userNotification;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Field;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class U_NotificationPostDTO {
    @NotBlank(message = "'title' field is null")
    @Size(min = 1, max = 50, message = "length of 'title' field must be between 1 and 50")
    private String title;

    @NotBlank(message = "'description' field is null")
    @Size(min = 1, max = 100, message = "length of 'description' field must be between 1 and 100")
    private String description;

    @NotBlank(message = "'related_to' field is null")
    @Size(min = 1, max = 50, message = "length of 'related_to' field must be between 1 and 50")
    @Field("related_to")
    private String relatedTo;

    @NotNull(message = "'related_id' field is null")
    @Field("related_id")
    private String relatedId;
}
