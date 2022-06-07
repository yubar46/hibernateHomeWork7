package repository;

import domain.Product;
import domain.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;

public class UserEntityManagerRepository  extends BaseRepositoryHibernate<User,Integer> implements UserRepository {
    EntityManagerFactory entityManagerFactory ;
    EntityManager entityManager;

    public UserEntityManagerRepository(EntityManagerFactory emf) {
        super(emf);
    }


    @Override
    Class getClassObject() {
        return User.class;
    }




    @Override
    public List<User> selectAllUsers() {
        entityManager = entityManagerFactory.createEntityManager();
        TypedQuery typedQuery = entityManager.createQuery("select u from  User u ",User.class);
        List<User> users = typedQuery.getResultList();

        return users;
    }


}
