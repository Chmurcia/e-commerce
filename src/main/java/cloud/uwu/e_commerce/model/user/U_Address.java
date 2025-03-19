package cloud.uwu.e_commerce.model.user;

import cloud.uwu.e_commerce.enums.Country;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;

@Document(collection = "u_address")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class U_Address {
    @Id
    private String id;

    @Field("user_id")
    private String userId;

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
