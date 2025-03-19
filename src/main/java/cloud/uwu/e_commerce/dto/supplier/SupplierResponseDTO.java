package cloud.uwu.e_commerce.dto.supplier;

import cloud.uwu.e_commerce.enums.Country;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SupplierResponseDTO {
    private String id;

    private String name;

    private String email;

    @JsonProperty("phone_number")
    private String phoneNumber;

    @JsonProperty("operating_countries")
    private List<Country> operatingCountries;

    @JsonProperty("created_date")
    private LocalDateTime createdDate;

    @JsonProperty("updated_date")
    private LocalDateTime updatedDate;
}
