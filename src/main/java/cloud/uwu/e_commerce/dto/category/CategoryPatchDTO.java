package cloud.uwu.e_commerce.dto.category;

import cloud.uwu.e_commerce.enums.Color;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryPatchDTO {
    @Size(max = 100, message = "length of 'name' field must be between 0 and 100 characters")
    private String name;

    private Color color;
}
