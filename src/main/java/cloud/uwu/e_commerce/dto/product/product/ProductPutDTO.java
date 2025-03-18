package cloud.uwu.e_commerce.dto.product.product;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductPutDTO {
    @NotBlank(message = "'name' field is null")
    @Size(min = 1, max = 100, message = "length of 'name' field must be between 1 and 100 characters")
    private String name;

    @NotBlank(message = "'description' field is null")
    @Size(min = 1, max = 2000, message = "length of 'description' field must be between 1 and 2000 characters")
    private String description;

    @NotNull(message = "'price' field is null")
    @DecimalMin(value = "0.0", message = "value of 'price' field is below 0")
    @Digits(integer = 10, fraction = 2, message = "'price' field has invalid format")
    private BigDecimal price;

    @NotNull(message = "'quantity' field is null")
    @Min(value = 0, message = "value of 'quantity' field is below 0")
    private Integer quantity;

    @NotNull(message = "'sold' field is null")
    @Min(value = 0, message = "value of 'sold' field is below 0")
    private Integer sold;

    @NotNull(message = "'image_url' field is null")
    @JsonProperty("image_url")
    private String imageUrl;
}
