package vn.edu.iuh.fit.backend.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @Column(name = "order_id", length = 20)
    private long orderId;
    @Column(name = "order_date", length = 6)
    private String orderDate;
    @ManyToOne
    @JoinColumn(name = "emp_id", nullable = false)
    @Column(name = "employee_id", length = 20)
    private Employee employee;
    @ManyToOne
    @JoinColumn(name = "cust_id", nullable = false)
    @Column(name = "cust_id", length = 20)
    private Customer customer;

    public Order() {
    }

    public Order(long orderId, String orderDate, Employee employee, Customer customer) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.employee = employee;
        this.customer = customer;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return orderId == order.orderId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId);
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", orderDate='" + orderDate + '\'' +
                ", employee=" + employee +
                ", customer=" + customer +
                '}';
    }
}
