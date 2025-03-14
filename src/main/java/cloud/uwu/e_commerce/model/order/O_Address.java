package cloud.uwu.e_commerce.model.order;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;

@Document(collection = "o_address")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class O_Address {
    @Id
    private String id;

    @Field("order_id")
    private String orderId;

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
