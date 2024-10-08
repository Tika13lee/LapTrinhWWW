package vn.edu.iuh.fit.backend.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "product_price")
public class ProductPrice {
    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    @Column(name = "product_id", length = 20)
    private Product product;
    @Id
    @Column(name = "price_date_time", length = 6)
    private LocalDateTime priceDateTime;
    @Column(name = "price", nullable = false)
    private double price;
    @Column(name = "note", length = 255)
    private String note;

    public ProductPrice() {
    }

    public ProductPrice(Product product, LocalDateTime priceDateTime, double price, String note) {
        this.product = product;
        this.priceDateTime = priceDateTime;
        this.price = price;
        this.note = note;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public LocalDateTime getPriceDateTime() {
        return priceDateTime;
    }

    public void setPriceDateTime(LocalDateTime priceDateTime) {
        this.priceDateTime = priceDateTime;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "ProductPrice{" +
                "product=" + product +
                ", priceDateTime=" + priceDateTime +
                ", price=" + price +
                ", note='" + note + '\'' +
                '}';
    }
}

