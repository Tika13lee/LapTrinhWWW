package vn.edu.iuh.fit.backend.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "product_image")
public class ProductImage {
    @Id
    @Column(name = "image_id", length = 20)
    private long imageId;
    @Column(name = "path", length = 250)
    private String path;
    @Column(name = "alternative", length = 250)
    private String alternative;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    public ProductImage() {
    }

    public ProductImage(long imageId, String path, String alternative, Product product) {
        this.imageId = imageId;
        this.path = path;
        this.alternative = alternative;
        this.product = product;
    }

    public long getImageId() {
        return imageId;
    }

    public void setImageId(long imageId) {
        this.imageId = imageId;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getAlternative() {
        return alternative;
    }

    public void setAlternative(String alternative) {
        this.alternative = alternative;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductImage that = (ProductImage) o;
        return imageId == that.imageId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(imageId);
    }

    @Override
    public String toString() {
        return "ProductImage{" +
                "imageId=" + imageId +
                ", path='" + path + '\'' +
                ", alternative='" + alternative + '\'' +
                ", product=" + product +
                '}';
    }
}
