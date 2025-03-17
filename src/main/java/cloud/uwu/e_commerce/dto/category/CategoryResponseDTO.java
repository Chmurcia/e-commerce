package cloud.uwu.e_commerce.dto.category;

import cloud.uwu.e_commerce.enums.Color;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryResponseDTO {
    private String id;

    private String name;

    private Color color;

    @JsonProperty("created_date")
    private LocalDateTime createdDate;

    @JsonProperty("updated_date")
    private LocalDateTime updatedDate;
}
