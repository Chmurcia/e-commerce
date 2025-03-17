package cloud.uwu.e_commerce.dto.discount;

import cloud.uwu.e_commerce.enums.DiscountType;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DiscountResponseDTO {
    private String id;

    private String code;

    private String description;

    private DiscountType type;

    private BigDecimal value;

    @JsonProperty("created_date")
    private LocalDateTime createdDate;

    @JsonProperty("updated_date")
    private LocalDateTime updatedDate;
}
