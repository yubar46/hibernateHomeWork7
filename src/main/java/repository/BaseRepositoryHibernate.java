package repository;

import domain.User;
import utli.ApplicationContext;
import utli.HibernateUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

public abstract class BaseRepositoryHibernate<T,ID > implements  Repository<T,ID> {
    EntityManagerFactory entityManagerFactory ;
    EntityManager entityManager;

    public BaseRepositoryHibernate(EntityManagerFactory emf){
        this.entityManagerFactory = emf;
    }


     abstract Class<T> getClassObject();

    @Override
    public void create(T t) {
    entityManager = entityManagerFactory.createEntityManager();
    try {
        entityManager.getTransaction().begin();
        entityManager.merge(t);
        entityManager.getTransaction().commit();
    }catch (Exception e ){
        System.out.println("wrong input");
        entityManager.getTransaction().rollback();
    }finally {
        entityManager.close();
    }

    }

    @Override
    public T select(ID id) {
        entityManager = entityManagerFactory.createEntityManager();
        T t = null;
        try {
            entityManager.getTransaction().begin();
            t= entityManager.find(getClassObject(),id);
            entityManager.getTransaction().commit();
        }catch (Exception e ){
            System.out.println("wrong input");
            entityManager.getTransaction().rollback();
        }finally {
            entityManager.close();
            return t;
        }
    }

    @Override
    public T Update(T t) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(t);
            entityManager.getTransaction().commit();
        }catch (Exception e ){
            System.out.println("wrong input");
            entityManager.getTransaction().rollback();
        }finally {
            entityManager.close();
            return t;
        }
    }


    @Override
    public void delete(T t) {
        entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(t);
            entityManager.getTransaction().commit();
        }catch (Exception e ){
            System.out.println("wrong input");
            entityManager.getTransaction().rollback();
        }finally {
            entityManager.close();

        }
    }

}

