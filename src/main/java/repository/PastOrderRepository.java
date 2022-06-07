package repository;

import domain.PastOrder;
import domain.User;

import java.util.List;

public interface PastOrderRepository extends Repository<PastOrder,Integer>  {

    List<PastOrder> selectAll(User User);

}
