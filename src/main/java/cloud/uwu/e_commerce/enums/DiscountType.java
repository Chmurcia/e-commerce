package cloud.uwu.e_commerce.enums;

import lombok.Getter;

@Getter
public enum DiscountType {
    FIXED("Fixed"),
    PERCENTAGE("Percentage");

    private final String type;

    DiscountType(String type) {
        this.type = type;
    }
}
