package cloud.uwu.e_commerce.dto.discount;

import cloud.uwu.e_commerce.enums.DiscountType;
import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DiscountDTO {
    @NotBlank(message = "'code' field is null")
    @Size(min = 64, max = 64, message = "length of 'code' field must be equal to 64")
    private String code;

    @NotBlank(message = "'description' field is null")
    @Size(min = 1, max = 300, message = "'length of 'description' field must be between 1 and 300 characters")
    private String description;

    @NotNull(message = "'type' field is null")
    private DiscountType type;

    @NotNull(message = "'value' field is null")
    @DecimalMin(value = "0.0", message = "value of 'value' field is below 0")
    @Digits(integer = 10, fraction = 2, message = "'value' field has invalid format")
    private BigDecimal value;
}
