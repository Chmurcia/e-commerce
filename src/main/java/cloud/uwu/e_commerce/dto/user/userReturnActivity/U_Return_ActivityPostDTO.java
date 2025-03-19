package cloud.uwu.e_commerce.dto.user.userReturnActivity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class U_Return_ActivityPostDTO {
    @NotNull(message = "'user_id' field is null")
    @JsonProperty("user_id")
    private String userId;

    @NotNull(message = "'return_id' field is null")
    @JsonProperty("return_id")
    private String returnId;

    @NotBlank(message = "'title' field is null")
    @Size(min = 1, max = 50, message = "length of 'title' field must be between 1 and 50 characters")
    private String title;

    @NotBlank(message = "'description' field is null")
    @Size(min = 1, max = 250, message = "length of 'description' field must be between 1 and 250 characters")
    private String description;
}
