package cloud.uwu.e_commerce.dto.user.user;

import cloud.uwu.e_commerce.enums.Role;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResponseDTO {
    private String id;

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("last_name")
    private String lastName;

    @JsonProperty("nick_name")
    private String nickName;

    private String email;

    @JsonProperty("hashed_password")
    private String hashedPassword;

    private Role role;

    @JsonProperty("created_date")
    private LocalDateTime createdDate;

    @JsonProperty("updated_date")
    private LocalDateTime updatedDate;
}
