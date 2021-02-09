package vn.kase.domain.v1.shipping_package;

public enum Status {
    ORDER_PLACED("ORDER PLACED"),
    READY_TO_SHIP("READY TO SHIP"),
    IN_TRANSIT("IN TRANSIT"),
    DELIVERED("DELIVERED");

    private final String status;

    private Status(String status) {
        this.status = status;
    }

    public String getStatus() {
        return this.status;
    }
}