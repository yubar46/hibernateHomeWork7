package repository;

import domain.Cart;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class CartEntityManagerRepository extends BaseRepositoryHibernate<Cart,Integer> implements CartRepository {
    EntityManagerFactory entityManagerFactory ;
    EntityManager entityManager;

    public CartEntityManagerRepository(EntityManagerFactory emf) {
        super(emf);
    }




    @Override
    Class<Cart> getClassObject() {
        return Cart.class;
    }
}
