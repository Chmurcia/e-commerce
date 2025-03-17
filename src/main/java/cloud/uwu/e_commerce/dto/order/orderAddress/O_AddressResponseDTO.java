package cloud.uwu.e_commerce.dto.order.orderAddress;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class O_AddressResponseDTO {
    private String id;

    @JsonProperty("order_id")
    private String orderId;

    private String country;

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
