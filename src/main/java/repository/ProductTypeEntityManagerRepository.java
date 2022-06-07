package repository;

import domain.Product;
import domain.ProductType;
import domain.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;

public class ProductTypeEntityManagerRepository implements ProductTypeRepository {
    EntityManagerFactory entityManagerFactory ;
    EntityManager entityManager;

    public ProductTypeEntityManagerRepository(EntityManagerFactory entityManagerFactory){
        this.entityManagerFactory = entityManagerFactory;
    }


    @Override
    public void create(ProductType productType) {

    }

    @Override
    public ProductType select(Integer pt_id) {
        entityManager = entityManagerFactory.createEntityManager();
        ProductType productType = new ProductType();
        try {
            entityManager.getTransaction().begin();
            productType= entityManager.find(ProductType.class,pt_id);
            entityManager.getTransaction().commit();
        }catch (Exception e ){
            System.out.println("wrong input");
            entityManager.getTransaction().rollback();
        }finally {
            entityManager.close();
            return productType;
        }
    }

    @Override
    public ProductType Update(ProductType productType) {
        return null;
    }

    @Override
    public void delete(ProductType productType) {

    }


    @Override
    public List<ProductType> showAllProductTypes() {
        entityManager = entityManagerFactory.createEntityManager();
        TypedQuery typedQuery = entityManager.createQuery("select pt from  ProductType pt", Product.class);
        List<ProductType> productTypes = typedQuery.getResultList();

        return productTypes;
    }
}
