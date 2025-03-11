package cloud.uwu.e_commerce.enums;

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
}
