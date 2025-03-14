package cloud.uwu.e_commerce.enums;

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
}
