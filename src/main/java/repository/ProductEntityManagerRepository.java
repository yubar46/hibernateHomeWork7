package repository;

import domain.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;

public class ProductEntityManagerRepository extends BaseRepositoryHibernate<Product,Integer> implements ProductRepository {
    EntityManagerFactory entityManagerFactory ;
    EntityManager entityManager;

    public ProductEntityManagerRepository(EntityManagerFactory emf) {
        super(emf);
    }


    @Override
    public List<Product> showPtP(Integer ptId) {
        entityManager = entityManagerFactory.createEntityManager();
        TypedQuery typedQuery = entityManager.createQuery("select p from  Product p where p.ProductTypeId="+ptId,Product.class);
        List<Product> products = typedQuery.getResultList();

        return products;
    }


    @Override
    Class<Product> getClassObject() {
      return   Product.class;
    }
}
