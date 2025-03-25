package cloud.uwu.e_commerce.dto.user.user;

import cloud.uwu.e_commerce.enums.Role;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {
    @NotBlank(message = "'first_name' field is null")
    @Size(min = 1, max = 50, message = "first_name of 'first_name' field must be between 1 and 50")
    @JsonProperty("first_name")
    private String firstName;

    @NotBlank(message = "'last_name' field is null")
    @Size(min = 1, max = 50, message = "length of 'last_name' field must be between 1 and 50")
    @JsonProperty("last_name")
    private String lastName;

    @NotBlank(message = "'nick_name' field is null")
    @Size(min = 1, max = 100, message = "length of 'last_name' field must be between 1 and 50")
    @JsonProperty("nick_name")
    private String nickName;

    @NotBlank(message = "'email' field is null")
    @Email(message = "'email' field has invalid format")
    private String email;

    @NotNull(message = "'role' field is null")
    private Role role;
}
