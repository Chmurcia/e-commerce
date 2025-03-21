package cloud.uwu.e_commerce.dto.warehouse.warehouse;

import cloud.uwu.e_commerce.model.product.Product;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WarehousePatchDTO {
    @Size(min = 2, max = 100, message = "length of 'name' field must be between 2 and 100")
    private String name;

    @NotEmpty(message = "'products' field is empty")
    private List<Product> products;
}
