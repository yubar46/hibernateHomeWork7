package domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = Cart.TABLE_NAME)
public class Cart {
    public static final String TABLE_NAME = "carts";
    private int cartPrice;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    int id;

    @OneToOne
    Address address;



    @OneToMany
    @JoinColumn(name= "cart_id",referencedColumnName = "id")
    private List<CartItem> products = new ArrayList<CartItem>();

    public Cart() {

    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void calculateCartPrice() {
        cartPrice = 0;
        for (int i = 0; i < products.size(); i++) {


            cartPrice += products.get(i).getAllPrice();

        }

    }

    public int getCartPrice() {
        return cartPrice;
    }

    public void setCartPrice(int cartPrice) {
        this.cartPrice = cartPrice;
    }


    public List<CartItem> getProducts() {
        return products;
    }

    public void setProducts(CartItem cartItem) {
        this.products.add(cartItem);
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setProducts(List<CartItem> products) {
        this.products = products;
    }
}
