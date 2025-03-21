package cloud.uwu.e_commerce.dto.warehouse.warehouseAddress;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class W_AddressPatchDTO {
    @Size(min = 1, max = 100, message = "length of 'state' field must be between 1 and 100 characters")
    private String state;

    @Size(min = 1, max = 100, message = "length of 'city' field must be between 1 and 100 characters")
    private String city;

    @Size(min = 1, max = 150, message = "length of 'street' field must be between 1 and 150 characters")
    private String street;

    @Size(min = 1, max = 10, message = "length of 'zip_code' field must be between 1 and 10 characters")
    @JsonProperty("zip_code")
    private String zipCode;
}
