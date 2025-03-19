package cloud.uwu.e_commerce.dto.user.userReturnActivity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class U_Return_ActivityResponseDTO {
    private String id;

    @JsonProperty("user_id")
    private String userId;

    @JsonProperty("return_id")
    private String returnId;

    private String title;

    private String description;

    @JsonProperty("created_date")
    private LocalDateTime createdDate;

    @JsonProperty("updated_date")
    private LocalDateTime updatedDate;
}
