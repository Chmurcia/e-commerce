package cloud.uwu.e_commerce.dto.product.productSettings;

import cloud.uwu.e_commerce.enums.Country;
import cloud.uwu.e_commerce.enums.Region;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class P_SettingsResponseDTO {
    private String id;

    @JsonProperty("product_id")
    private String productId;

    @Builder.Default
    @JsonProperty("available_regions")
    private List<Region> availableRegions = new ArrayList<>();

    @Builder.Default
    @JsonProperty("available_countries")
    private List<Country> availableCountries = new ArrayList<>();

    @JsonProperty("created_date")
    private LocalDateTime createdDate;

    @JsonProperty("updated_date")
    private LocalDateTime updatedDate;
}
