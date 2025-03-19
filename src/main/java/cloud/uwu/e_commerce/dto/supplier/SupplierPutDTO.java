package cloud.uwu.e_commerce.dto.supplier;

import cloud.uwu.e_commerce.enums.Country;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SupplierPutDTO {
    @NotBlank(message = "'name' field is null")
    @Size(min = 1, max = 100, message = "length of 'name' field must be between 1 and 150 characters")
    private String name;

    @NotBlank(message = "'email' field is null")
    @Email(message = "'email' field has invalid format")
    private String email;

    @NotBlank(message = "'phone_number' field is null")
    @Pattern(regexp = "^(\\\\+\\\\d{1,3}\\\\s?)?((\\\\d{3}[- ]?){2}\\\\d{3})$")
    @JsonProperty("phone_number")
    private String phoneNumber;

    @NotNull(message = "'operating_countries' field is null")
    @NotEmpty(message = "'operating_countries' field is empty")
    @JsonProperty("operating_countries")
    private List<Country> operatingCountries;
}
