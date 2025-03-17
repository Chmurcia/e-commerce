package cloud.uwu.e_commerce.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

@Getter
public enum DiscountType {
    FIXED("Fixed"),
    PERCENTAGE("Percentage");

    private final String type;

    DiscountType(String type) {
        this.type = type;
    }

    @JsonValue
    public String getName() {
        return type;
    }

    @JsonCreator
    public static DiscountType fromName(String type) {
        for (DiscountType discountType : values()) {
            if (discountType.type.equalsIgnoreCase(type)) {
                return discountType;
            }
        }
        throw new IllegalArgumentException("Unknown type: " + type);
    }
}
