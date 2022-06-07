package domain;

import javax.persistence.*;

@Entity
@Table(name = CartItem.TABLE_NAME)
public class CartItem {
    public static final String TABLE_NAME = "cart_Items";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;
    private int number;
    int allPrice;

    public CartItem(Product product, int number) {
        this.product = product;
        this.number = number;
        this.allPrice = product.getPrice() * number;

    }

    public CartItem() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getAllPrice() {
        return allPrice;
    }

    public void setAllPrice(int allPrice) {
        this.allPrice = allPrice;
    }

}
