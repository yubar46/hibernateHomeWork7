package repository;

import domain.Address;

import javax.persistence.EntityManagerFactory;

public class AddressEntityManagerRepository extends BaseRepositoryHibernate<Address,Integer> implements AddressRepository {
    public AddressEntityManagerRepository(EntityManagerFactory emf) {
        super(emf);
    }

    @Override
    Class<Address> getClassObject() {
        return null;
    }
}
