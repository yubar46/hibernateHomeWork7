package repository;
/*
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

        try {
            entityManager.getTransaction().begin();
            TypedQuery<T> query = entityManager.createQuery("",)
            entityManager.getTransaction().commit();
        }catch (Exception e ){
            System.out.println("wrong input");
            entityManager.getTransaction().rollback();
        }finally {
            entityManager.close();
        }

        return null;
    }

    @Override
    public T Update(T t) {
        return null;
    }


}
*/
