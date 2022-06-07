package repository;

import domain.Product;

import java.util.List;

public interface ProductRepository extends Repository<Product,Integer> {


    List<Product> showPtP(Integer ptId);

}
