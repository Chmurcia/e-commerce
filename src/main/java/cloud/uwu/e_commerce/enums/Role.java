package cloud.uwu.e_commerce.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Role {
    USER("User"),
    ADMIN("Admin"),
    OWNER("Owner");

    private final String roleName;

    Role(String roleName) {
        this.roleName = roleName;
    }

    @JsonValue
    public String getName() {
        return roleName;
    }

    @JsonCreator
    public static Role fromName(String roleName) {
        for (Role role : values()) {
            if (role.roleName.equalsIgnoreCase(roleName)) {
                return role;
            }
        }
        throw new IllegalArgumentException("Unknown order status: " + roleName);
    }
}
