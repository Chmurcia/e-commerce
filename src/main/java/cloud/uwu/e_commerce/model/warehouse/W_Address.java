package cloud.uwu.e_commerce.model.warehouse;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class W_Address {
    @Id
    private String id;

    @Field("warehouse_id")
    private String warehouseId;

    private String country;

    private String state;

    private String city;

    private String street;

    @Field("zip_code")
    private String zipCode;

    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime updatedDate;
}
