package cloud.uwu.e_commerce.dto.warehouse.warehouse;

import cloud.uwu.e_commerce.model.product.Product;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WarehousePutDTO {
    @NotBlank(message = "'user_id' field is null")
    @Size(min = 2, max = 100, message = "length of 'name' field must be between 2 and 100")
    private String name;

    @NotNull(message = "'products' field is null")
    @NotEmpty(message = "'products' field is empty")
    private List<Product> products;
}
