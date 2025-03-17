package cloud.uwu.e_commerce.dto.order.orderAddress;

import cloud.uwu.e_commerce.enums.Country;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class O_AddressPatchDTO {
    private Country country;

    @Size(max = 100, message = "length of 'state' field must be between 0 and 100 characters")
    private String state;

    @Size(max = 100, message = "length of 'city' field must be between 0 and 100 characters")
    private String city;

    @Size(max = 150, message = "length of 'street' field must be between 0 and 150 characters")
    private String street;

    @Size(max = 10, message = "length of 'zip_code' field must be between 0 and 10 characters")
    @JsonProperty("zip_code")
    private String zipCode;
}
