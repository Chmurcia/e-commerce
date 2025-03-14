package cloud.uwu.e_commerce.model.supplier;

import cloud.uwu.e_commerce.enums.Country;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Supplier {
    @Id
    private String id;

    private String name;

    private String email;

    @Field("phone_number")
    private String phoneNumber;

    @Field("operating_countries")
    private List<Country> operatingCountries;

    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime updatedDate;
}
