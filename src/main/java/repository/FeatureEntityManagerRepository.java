package repository;

import domain.Feature;

import javax.persistence.EntityManagerFactory;

public class FeatureEntityManagerRepository extends BaseRepositoryHibernate<Feature,Integer> implements FeatureRepository {
    public FeatureEntityManagerRepository(EntityManagerFactory emf) {
        super(emf);
    }

    @Override
    Class<Feature> getClassObject() {
        return null;
    }
}
