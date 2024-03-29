 package utli;

import domain.*;

import java.sql.SQLException;
import java.util.Scanner;

public class Menu {

    Scanner inputNumber = new Scanner(System.in);
    Scanner inputString = new Scanner(System.in);
    Scanner inputString2 = new Scanner(System.in);
    ApplicationContext applicationContext = new ApplicationContext();
    boolean exit = false;

    public Menu() throws SQLException, ClassNotFoundException {
    }

    public void showFirstMenu() {
        System.out.printf("%s %n %s %n %s %n %s %n ", "welcome to homework5 market"
                , "for login enter 1 ", "for sign up enter 2", "for exit enter-1");


    }

    public int customerSelect() {
        int customerSelect = inputNumber.nextInt();

        return customerSelect;
    }


    public int cheekSelect(int customerSelect) {
        int correctSelect = 0;
        while (correctSelect == 0) {
            if (customerSelect == 1 || customerSelect == 2 || customerSelect == -1) {
                correctSelect = customerSelect;
            } else {
                System.out.println("wrong number try again");
                showFirstMenu();
                customerSelect();
            }

        }
        return correctSelect;
    }


    public void enterMenu(int select) throws SQLException {


        if (select == 1) {
            applicationContext.setUser(login());
            insideMenu(applicationContext.getUser());

        }
        if (select == 2) {
            applicationContext.setUser(singUp());
            insideMenu(applicationContext.getUser());

        }


        if (select == -1) {
            System.out.println("goodbye");
            exit = true;
        }

    }

    private void insideMenu(User user) throws SQLException {

        int select = 0;

        while (select != -1) {
            System.out.printf("  %s %n %s %n %s %n", "for view products enter 1 "
                    , "for view your past orders enter 2 ", "for exit enter-1");
            select = customerSelect();
            if (select == 1) {
                viewProduct();
                int choice = 0;
                while (choice != -1) {
                    showProductMenu();
                    choice = inputNumber.nextInt();

                    if (choice == 1) {
                        selectToCart(user);


                    }
                    if (choice == 2) {
                        applicationContext.getCartRepository().viewCart(applicationContext.getCart().getUserId());
                        showCartMenu();

                        int cartChoice = inputNumber.nextInt();
                        if (cartChoice == 1) {
                            deleteOrderFromCart(user);

                        }
                        if (cartChoice == 2) {

                            if (user.getAddresses().isEmpty()) {
                                addAddress(user);
                                selectAddress(user);


                            } else {
                                System.out.println("for select address enter 1--for add new address enter2");
                                int addressSelect = inputNumber.nextInt();


                                if (addressSelect == 1) {
                                    selectAddress(user);
                                }
                                if (addressSelect == 2) {
                                    addAddress(user);
                                    selectAddress(user);

                                }


                            }

                        }
                        if (cartChoice == -1) {
                            break;
                        }

                    }
                    if (choice == 3) {
                        viewProduct();
                    }


                }


            }
            if (select == 2) {
                applicationContext.getPastOrdersRepository().selectPastOrders(user.getId());

            }


        }


    }

    private void showProductMenu() {
        System.out.println("for add product to your card enter 1");
        System.out.println("for view your cart enter 2 ");
        System.out.println("for view another product type enter3  ");
        System.out.println("for exit enter -1");
    }

    private void selectToCart(User user) throws SQLException {
        System.out.println("enter product id");
        int productId = inputNumber.nextByte();

        Product product = applicationContext.getProductRepository().selectProduct(productId);

        boolean exist = false;
        int nOfOrder;
        do {
            System.out.println("enter number of product");
            nOfOrder = inputNumber.nextInt();

            exist = applicationContext.getProductRepository().isExist(product, nOfOrder);
            if (!exist) {
                System.out.println("item is not enough exist choice number again");
            }
        } while (exist = false);
        CartItem cartItem = new CartItem(product, nOfOrder);

        if (applicationContext.getCart().getProducts().size() < 5) {
            applicationContext.getCart().setProducts(cartItem);
            applicationContext.getCart().setUserId(user.getId());
            applicationContext.getCart().calculateCartPrice();


            int id = applicationContext.getCartRepository().addToCart(applicationContext.getCart(), user.getId());
            applicationContext.getCart().setId(id);
            applicationContext.setCart(applicationContext.getCart());
            product.setNumber(product.getNumber() - nOfOrder);
            applicationContext.getProductRepository().editProduct(product, (product.getNumber()));


        } else System.out.println("cart is full");
    }

    private void showCartMenu() {
        System.out.println("for delete order from cart enter 1");
        System.out.println("Finalize the shopping cart enter 2");
        System.out.println("for back to main menu enter -1");
    }

    private void deleteOrderFromCart(User user) throws SQLException {
        System.out.println("enter cart id");
        int cartId = inputNumber.nextInt();
        System.out.println("please enter product id");
        int productId = inputNumber.nextInt();
        applicationContext.getCartRepository().deleteFromCart(cartId, productId);
        Cart cart = new Cart();
        cart = applicationContext.getCartRepository().selectCart(user.getId());
        applicationContext.setCart(cart);
        applicationContext.getCartRepository().addToCart(cart, user.getId());
    }

    private void addAddress(User user) throws SQLException {
        System.out.println("please enter your State");
        String state = inputString.next();
        System.out.println("please enter your city");
        String city = inputString.next();
        System.out.println("please enter your street name");
        String streetName = inputString.next();
        System.out.println("please enter your pistol code");
        String pistolCode = inputString.next();
        Address address = new Address(state, city, streetName, pistolCode);
        address.setUserId(user.getId());
        int addressId = applicationContext.getAddressRepository().addAddress(address);
        address.setId(addressId);
        user.addAddress(address);
    }

    private void viewProduct() throws SQLException {
        applicationContext.getProductTypeRepository().readAllProductTypes();
        System.out.println("please select productType");
        int productType = inputNumber.nextInt();
        applicationContext.getProductRepository().showAllProducts(productType);
    }

    public User singUp() throws SQLException {
        String validUserName;
        String userName;
        do {
            System.out.println("please enter your user name");
            userName = inputString.next();

            if (applicationContext.getUserRepository().validUser(userName))
                System.out.println("this userName is already taken");


        } while (applicationContext.getUserRepository().validUser(userName));
        String password = cheekPassword();
        System.out.println("please enter your first Name");
        String firstName = inputString2.nextLine();
        System.out.println("please enter your last Name");
        String lastName = inputString2.nextLine();
        String phoneNumber = cheekPhoneNumber();
        String email = cheekEmail();

        User user = new User(userName, password, firstName, lastName, phoneNumber, email);

        int userId = applicationContext.getUserRepository().addUser(user);
        user.setId(userId);
        return user;


    }

    public User login() throws SQLException {
        boolean cheekLogin = false;
        User user;
        String username;
        String password;
        int userId = -1;
        while (!cheekLogin) {
            System.out.println("please enter your username ");
            username = inputString.next();
            System.out.println("please enter your password");
            password = inputString.next();
            userId = cheekLogin(username, password);
            if (userId != -1) cheekLogin = true;
            else System.out.println("user name or password is wrong");
        }
        user = applicationContext.getUserRepository().readUser(userId);

        applicationContext.getUser().setAddresses(applicationContext.getAddressRepository().selectAddress(userId));
        return user;


    }


    private String cheekPassword() {

        String cheekPassword;
        String password;
        do {
            System.out.println("please enter your password");
            password = inputString.next();
            System.out.println("please enter your password");
            cheekPassword = inputString.next();
            if (password.equals(cheekPassword)) ;

        } while (!cheekPassword.equals(password));
        return cheekPassword;
    }

    private String cheekPhoneNumber() throws SQLException {
        String phoneNumber = null;
        while (phoneNumber == null) {
            System.out.println("please enter your phone number");
            String pNumber = inputString.next();

            if (!applicationContext.getUserRepository().validPhoneNumber(pNumber)) phoneNumber = pNumber;

        }
        return phoneNumber;

    }

    private String cheekEmail() throws SQLException {
        String email = null;
        while (email == null) {
            System.out.println("'please enter your email");
            String inputEmail = inputString.next();

            if (!applicationContext.getUserRepository().validEmail(inputEmail)) email = inputEmail;

        }
        return email;
    }

    private int cheekLogin(String username, String password) throws SQLException {
        return applicationContext.getUserRepository().cheekLogin(username, password);

    }

    public void selectAddress(User user) throws SQLException {
        applicationContext.getAddressRepository().readAddress(user.getId());
        System.out.println("please enter address id");
        int addressId = inputNumber.nextInt();
        PastOrders pastOrders = new PastOrders();
        Address address = new Address();
        for (int i = 0; i < user.getAddresses().size(); i++) {
            if (user.getAddresses().get(i).getId() == addressId) {
                address.setState(user.getAddresses().get(i).getState());
                address.setCity(user.getAddresses().get(i).getCity());
                address.setStreetName(user.getAddresses().get(i).getStreetName());
                address.setPistolCode(user.getAddresses().get(i).getPistolCode());
                pastOrders.setAddress(address);

            }
        }

        for (int i = 0; i < applicationContext.getCart().getProducts().size(); i++) {
            pastOrders.setProduct(applicationContext.getCart().getProducts().get(i).getProduct());
            pastOrders.setPrice(applicationContext.getCart().getProducts().get(i).getProduct().getPrice());
            pastOrders.setTotalPrice(applicationContext.getCart().getProducts().get(i).getAllPrice());
            pastOrders.setAllPrice(applicationContext.getCart().getCartPrice());
            pastOrders.setUserID(user.getId());
            pastOrders.getProduct().setNumber(applicationContext.getCart().getProducts().get(i).getNumber());
            user.getPastOrders().add(pastOrders);
            applicationContext.getPastOrdersRepository().AddToPastOrders(pastOrders, user);

        }
        applicationContext.getCartRepository().eraseCart(user.getId());


    }
}

