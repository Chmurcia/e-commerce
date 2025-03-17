package cloud.uwu.e_commerce.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum OrderStatus {
    PENDING("Pending"),
    PROCESSING("Processing"),
    SHIPPED("Shipped"),
    DELIVERED("Delivered"),
    CANCELLED("Cancelled"),
    COMPLETED("Completed"),
    RETURNED("Returned"),
    REFUNDED("Refunded"),
    FAILED("Failed"),
    AWAITING_PAYMENT("Awaiting Payment"),
    PARTIALLY_SHIPPED("Partially Shipped"),
    BACK_ORDERED("Back Ordered"),
    PRE_ORDERED("Pre Ordered");

    private final String statusName;

    OrderStatus(String statusName) {
        this.statusName = statusName;
    }

    @JsonValue
    public String getName() {
        return statusName;
    }

    @JsonCreator
    public static OrderStatus fromName(String statusName) {
        for (OrderStatus orderStatus : values()) {
            if (orderStatus.statusName.equalsIgnoreCase(statusName)) {
                return orderStatus;
            }
        }
        throw new IllegalArgumentException("Unknown order status: " + statusName);
    }
}
