package cloud.uwu.e_commerce.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

@Getter
public enum ReturnStatus {
    PENDING("Pending"),
    ACCEPTED("Accepted"),
    REJECTED("Rejected");

    private final String status;

    ReturnStatus(String status) {
        this.status = status;
    }

    @JsonValue
    public String getName() {
        return status;
    }

    @JsonCreator
    public static ReturnStatus fromName(String status) {
        for (ReturnStatus returnStatus : values()) {
            if (returnStatus.status.equalsIgnoreCase(status)) {
                return returnStatus;
            }
        }
        throw new IllegalArgumentException("Unknown return status: " + status);
    }
}
