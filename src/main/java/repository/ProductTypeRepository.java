package repository;

import domain.ProductType;

import java.util.List;

public interface ProductTypeRepository extends Repository<ProductType,Integer> {

    List<ProductType> showAllProductTypes();

}
