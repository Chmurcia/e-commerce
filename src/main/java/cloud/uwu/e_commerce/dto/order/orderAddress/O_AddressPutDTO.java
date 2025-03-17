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
public class O_AddressPutDTO {
    @NotNull(message = "'country' field is null")
    private Country country;

    @NotNull(message = "'state' field is null")
    @Size(max = 100, message = "length of 'state' field must be between 0 and 100 characters")
    private String state;

    @NotNull(message = "'city' field is null")
    @Size(max = 100, message = "length of 'city' field must be between 0 and 100 characters")
    private String city;

    @NotNull(message = "'street' field is null")
    @Size(max = 150, message = "length of 'street' field must be between 0 and 150 characters")
    private String street;

    @NotNull(message = "'zip_code' field is null")
    @Size(max = 10, message = "length of 'zip_code' field must be between 0 and 10 characters")
    @JsonProperty("zip_code")
    private String zipCode;
}
