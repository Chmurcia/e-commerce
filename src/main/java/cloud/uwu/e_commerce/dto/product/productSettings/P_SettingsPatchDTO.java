package cloud.uwu.e_commerce.dto.product.productSettings;

import cloud.uwu.e_commerce.enums.Country;
import cloud.uwu.e_commerce.enums.Region;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class P_SettingsPatchDTO {
    @NotEmpty(message = "'available_regions' is empty")
    @JsonProperty("available_regions")
    private List<Region> availableRegions;

    @NotEmpty(message = "'available_countries' is empty")
    @JsonProperty("available_countries")
    private List<Country> availableCountries;
}
