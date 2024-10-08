package vn.edu.iuh.fit.backend.entities;

public enum EmployeeStatus {
    WORKING(1), ON_LEAVE(2), RESIGNED(3);

    private final int value;

    private EmployeeStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}
