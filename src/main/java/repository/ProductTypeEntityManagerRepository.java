package repository;

import domain.Product;
import domain.ProductType;
import domain.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;

public class ProductTypeEntityManagerRepository extends BaseRepositoryHibernate<ProductType,Integer> implements ProductTypeRepository {
    EntityManagerFactory entityManagerFactory ;
    EntityManager entityManager;

    public ProductTypeEntityManagerRepository(EntityManagerFactory emf) {
        super(emf);
    }


    @Override
    public List<ProductType> showAllProductTypes() {
        entityManager = entityManagerFactory.createEntityManager();
        TypedQuery typedQuery = entityManager.createQuery("select pt from  ProductType pt", ProductType.class);
        List<ProductType> productTypes = typedQuery.getResultList();

        return productTypes;
    }

    @Override
    Class<ProductType> getClassObject() {
        return ProductType.class;
    }
}
