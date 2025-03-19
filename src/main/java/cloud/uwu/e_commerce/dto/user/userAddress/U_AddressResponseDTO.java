package cloud.uwu.e_commerce.dto.user.userAddress;

import cloud.uwu.e_commerce.enums.Country;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class U_AddressResponseDTO {
    private String id;

    @JsonProperty("user_id")
    private String userId;

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
