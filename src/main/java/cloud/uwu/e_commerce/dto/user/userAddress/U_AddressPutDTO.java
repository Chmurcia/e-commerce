package cloud.uwu.e_commerce.dto.user.userAddress;

import cloud.uwu.e_commerce.enums.Country;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class U_AddressPutDTO {
    @NotNull(message = "'' field is null")
    private Country country;

    @NotBlank(message = "'state' field is null")
    @Size(min = 1, max = 50, message = "length of 'state' must be between 1 and 50 characters")
    private String state;

    @NotBlank(message = "'city' field is null")
    @Size(min = 1, max = 100, message = "length of 'city' must be between 1 and 100 characters")
    private String city;

    @NotBlank(message = "'street' field is null")
    @Size(min = 1, max = 100, message = "length of 'street' must be between 1 and 100 characters")
    private String street;

    @NotBlank(message = "'zip_code' field is null")
    @Size(min = 1, max = 10, message = "length of 'zip_code' field must be between 1 and 10 characters")
    @JsonProperty("zip_code")
    private String zipCode;
}
