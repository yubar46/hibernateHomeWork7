package repository;

import domain.Attribute;

import javax.persistence.EntityManagerFactory;

public class AttributeEntityManagerRepository extends BaseRepositoryHibernate<Attribute,Integer> implements AttributeRepository {
    public AttributeEntityManagerRepository(EntityManagerFactory emf) {
        super(emf);
    }

    @Override
    Class<Attribute> getClassObject() {
        return null;
    }
}
