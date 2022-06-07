package repository;

import domain.PastOrder;
import domain.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;

public class PastOrderEntityManagerRepository extends BaseRepositoryHibernate<PastOrder,Integer> implements PastOrderRepository {
    EntityManagerFactory entityManagerFactory ;
    EntityManager entityManager;

    public PastOrderEntityManagerRepository(EntityManagerFactory emf) {
        super(emf);
    }


    @Override
    public List<PastOrder> selectAll(User user) {
        entityManager = entityManagerFactory.createEntityManager();
        TypedQuery typedQuery = entityManager.createQuery("select ps from  PastOrder ps where ps.user="+user, PastOrder.class);
        List<PastOrder> pastOrders = typedQuery.getResultList();

        return pastOrders;
    }

    @Override
    Class<PastOrder> getClassObject() {
        return PastOrder.class;
    }
}
