package cloud.uwu.e_commerce.model.warehouse;

import cloud.uwu.e_commerce.enums.Country;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;

@Document(collection = "w_address")
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

    private Country country;

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
