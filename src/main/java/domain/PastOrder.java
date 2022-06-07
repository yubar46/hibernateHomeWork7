package domain;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = PastOrder.TABLE_NAME)
public class PastOrder {
    public static final String TABLE_NAME = "past_orders";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private int id;


    @OneToMany
    private List<Product> products;
    @ManyToOne
    private User user;
    private int price;

    private int allPrice;
    private int totalPrice;

    public PastOrder() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public PastOrder(List<Product> products, User user, int price) {
        this.products = products;
        this.user = user;
        this.price = price;
    }


    public int getAllPrice() {
        return allPrice;
    }

    public void setAllPrice(int allPrice) {
        this.allPrice = allPrice;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    @ManyToOne
    private Address address;

    public User user() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public User getUser() {
        return user;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


    public void setProduct(Product product) {
        products.add(product);
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
