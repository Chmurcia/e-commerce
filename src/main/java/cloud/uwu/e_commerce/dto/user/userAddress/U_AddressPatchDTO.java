package cloud.uwu.e_commerce.dto.user.userAddress;

import cloud.uwu.e_commerce.enums.Country;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class U_AddressPatchDTO {
    private Country country;

    @Size(min = 1, max = 50, message = "length of 'state' must be between 1 and 50 characters")
    private String state;

    @Size(min = 1, max = 100, message = "length of 'city' must be between 1 and 100 characters")
    private String city;

    @Size(min = 1, max = 100, message = "length of 'street' must be between 1 and 100 characters")
    private String street;

    @Size(min = 1, max = 10, message = "length of 'zip_code' field must be between 1 and 10 characters")
    @JsonProperty("zip_code")
    private String zipCode;
}
