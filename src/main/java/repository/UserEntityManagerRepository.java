package repository;

import domain.Product;
import domain.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;

public class UserEntityManagerRepository implements UserRepository {
    EntityManagerFactory entityManagerFactory ;
    EntityManager entityManager;
    public  UserEntityManagerRepository(EntityManagerFactory entityManagerFactory){
        this.entityManagerFactory =entityManagerFactory;
    }





    @Override
    public void create(User user) {
        entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(user);
            entityManager.getTransaction().commit();
        }catch (Exception e ){
            System.out.println("wrong input");
            entityManager.getTransaction().rollback();
        }finally {
            entityManager.close();
        }
    }

    @Override
    public User select(Integer user_id) {
        entityManager = entityManagerFactory.createEntityManager();
        User user = new User();
        try {
            entityManager.getTransaction().begin();
            user= entityManager.find(User.class,user_id);
            entityManager.getTransaction().commit();
        }catch (Exception e ){
            System.out.println("wrong input");
            entityManager.getTransaction().rollback();
        }finally {
            entityManager.close();
            return user;
        }
    }

    @Override
    public User Update(User user) {
        entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(user);
            entityManager.getTransaction().commit();
        }catch (Exception e ){
            System.out.println("wrong input");
            entityManager.getTransaction().rollback();
        }finally {
            entityManager.close();
            return user;
        }
    }

    @Override
    public void delete(User user) {
        entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(user);
            entityManager.getTransaction().commit();
        }catch (Exception e ){
            System.out.println("wrong input");
            entityManager.getTransaction().rollback();
        }finally {
            entityManager.close();

        }
    }

    @Override
    public List<User> selectAllUsers() {
        entityManager = entityManagerFactory.createEntityManager();
        TypedQuery typedQuery = entityManager.createQuery("select u from  User u ",User.class);
        List<User> users = typedQuery.getResultList();

        return users;
    }
}
