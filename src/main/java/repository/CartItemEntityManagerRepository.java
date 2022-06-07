package repository;

import domain.CartItem;

import javax.persistence.EntityManagerFactory;

public class CartItemEntityManagerRepository extends BaseRepositoryHibernate<CartItem,Integer> implements CartItemRepository {
    public CartItemEntityManagerRepository(EntityManagerFactory emf) {
        super(emf);
    }

    @Override
    Class<CartItem> getClassObject() {
        return CartItem.class;
    }
}
