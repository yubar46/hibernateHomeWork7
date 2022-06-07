package domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = Product.TABLE_NAME)
public class Product {
    public static final String TABLE_NAME = "products";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int number;

    @Column(nullable = false)
    private int price;

    private String image;

    @Column(nullable = false)
    private int ProductTypeId;

    @OneToMany
    @JoinColumn(name = "product_Id",referencedColumnName = "id")
    private List<Feature> features;

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public Product() {

    }

    public List<Feature> getFeatures() {
        return features;
    }

    public void setFeatures(List<Feature> features) {
        this.features = features;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductTypeId() {
        return ProductTypeId;
    }

    public void setProductTypeId(int productTypeId) {
        ProductTypeId = productTypeId;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", number=" + number +
                ", price=" + price +
                ", ProductTypeId=" + ProductTypeId +
                ", features=" + features +
                '}';
    }
}
