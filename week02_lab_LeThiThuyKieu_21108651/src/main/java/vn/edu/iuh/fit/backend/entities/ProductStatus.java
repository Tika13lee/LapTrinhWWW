package vn.edu.iuh.fit.backend.entities;

public enum ProductStatus {
    ACTIVE(1), SUSPENDED(0), DISCONTINUED(-1);

    private final int value;

    private ProductStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
