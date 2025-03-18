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
public class ProductPatchDTO {
    @Size(max = 100, message = "length of 'name' field must be between 0 and 100 characters")
    private String name;

    @Size(max = 2000, message = "length of 'description' field must be between 0 and 2000 characters")
    private String description;

    @DecimalMin(value = "0.0", message = "value of 'price' field is below 0")
    @Digits(integer = 10, fraction = 2, message = "'price' field has invalid format")
    private BigDecimal price;

    @Min(value = 0, message = "value of 'quantity' field is below 0")
    private Integer quantity;

    @Min(value = 0, message = "value of 'sold' field is below 0")
    private Integer sold;

    @JsonProperty("image_url")
    private String imageUrl;
}
