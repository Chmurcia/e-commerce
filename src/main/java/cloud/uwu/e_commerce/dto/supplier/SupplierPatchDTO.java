package cloud.uwu.e_commerce.dto.supplier;

import cloud.uwu.e_commerce.enums.Country;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SupplierPatchDTO {
    @Size(min = 1, max = 100, message = "length of 'name' field must be between 1 and 150 characters")
    private String name;

    @Email(message = "'email' field has invalid format")
    private String email;

    @Pattern(regexp = "^(\\\\+\\\\d{1,3}\\\\s?)?((\\\\d{3}[- ]?){2}\\\\d{3})$")
    @JsonProperty("phone_number")
    private String phoneNumber;

    @NotEmpty(message = "'operating_countries' field is empty")
    @JsonProperty("operating_countries")
    private List<Country> operatingCountries;
}
