package repository;

import domain.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;

public class ProductEntityManagerRepository implements ProductRepository {
    EntityManagerFactory entityManagerFactory ;
    EntityManager entityManager;

    public ProductEntityManagerRepository(EntityManagerFactory emf){
        this.entityManagerFactory = emf;
    }






    @Override
    public List<Product> showPtP(Integer ptId) {
        entityManager = entityManagerFactory.createEntityManager();
        TypedQuery typedQuery = entityManager.createQuery("select p from  Product p where p.ProductTypeId="+ptId,Product.class);
        List<Product> products = typedQuery.getResultList();

        return products;
    }


    @Override
    public void create(Product product) {
        entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(product);
            entityManager.getTransaction().commit();
        }catch (Exception e ){
            System.out.println("wrong input");
            entityManager.getTransaction().rollback();
        }finally {
            entityManager.close();
        }
    }

    @Override
    public Product select(Integer product_id) {
        entityManager = entityManagerFactory.createEntityManager();
            Product product = new Product();
        try {
            entityManager.getTransaction().begin();
           product= entityManager.find(Product.class,product_id);
            entityManager.getTransaction().commit();
        }catch (Exception e ){
            System.out.println("wrong input");
            entityManager.getTransaction().rollback();
        }finally {
            entityManager.close();
            return product;
        }


    }

    @Override
    public Product Update(Product product) {
        entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(product);
            entityManager.getTransaction().commit();
        }catch (Exception e ){
            System.out.println("wrong input");
            entityManager.getTransaction().rollback();
        }finally {
            entityManager.close();
            return product;
        }
    }

    @Override
    public void delete(Product product) {
        entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(product);
            entityManager.getTransaction().commit();
        }catch (Exception e ){
            System.out.println("wrong input");
            entityManager.getTransaction().rollback();
        }finally {
            entityManager.close();

        }
    }
}
