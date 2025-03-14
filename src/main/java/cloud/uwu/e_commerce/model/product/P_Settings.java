package cloud.uwu.e_commerce.model.product;

import cloud.uwu.e_commerce.enums.Country;
import cloud.uwu.e_commerce.enums.Region;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;
import java.util.List;

@Document(collection = "p_settings")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class P_Settings {
    @Id
    private String id;

    @Field("product_id")
    private String productId;

    @Field("is_public")
    private Boolean isPublic;

    @Field("available_regions")
    private List<Region> availableRegions;

    @Field("available_countries")
    private List<Country> availableCountries;

    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime updatedDate;
}
