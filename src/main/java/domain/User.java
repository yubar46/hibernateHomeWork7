package domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
@Entity
@Table(name =User.TABLE_NAME)
public class User {
    public static final String TABLE_NAME = "users";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true,nullable = false)
    private String userName;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(unique = true)
    private String phoneNumber;

    @Column(unique = true)
    private String email;



    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name="user_Id")
    private List<Address> addresses = new ArrayList<Address>();

    @OneToOne(fetch = FetchType.LAZY)
    private Cart cart = new Cart();

    @OneToMany(mappedBy = "user")

    private List<PastOrder> pastOrders = new LinkedList<PastOrder>();


    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public User(String userName, String password, String firstName, String lastName, String phoneNumber, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.userName = userName;
        this.password = password;


    }

    public User() {

    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public List<Address> getAddresses() {
        return addresses;
    }

    public void addAddress(Address addresses) {
        this.addresses.add(addresses);
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }


    public List<PastOrder> getPastOrders() {
        return pastOrders;
    }

    public void setPastOrders(List<PastOrder> pastOrders) {
        this.pastOrders = pastOrders;
    }
}
