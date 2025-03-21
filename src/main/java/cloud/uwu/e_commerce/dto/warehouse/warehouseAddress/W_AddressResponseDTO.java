package cloud.uwu.e_commerce.dto.warehouse.warehouseAddress;

import cloud.uwu.e_commerce.enums.Country;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class W_AddressResponseDTO {
    private String id;

    @JsonProperty("warehouse_id")
    private String warehouseId;

    private Country country;

    private String state;

    private String city;

    private String street;

    @JsonProperty("zip_code")
    private String zipCode;

    @JsonProperty("created_date")
    private LocalDateTime createdDate;

    @JsonProperty("updated_date")
    private LocalDateTime updatedDate;
}
