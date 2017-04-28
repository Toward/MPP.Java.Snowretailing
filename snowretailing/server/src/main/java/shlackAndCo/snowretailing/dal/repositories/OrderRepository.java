package shlackAndCo.snowretailing.dal.repositories;

import org.springframework.stereotype.Repository;
import shlackAndCo.snowretailing.dal.contracts.entities.IBrandEntity;
import shlackAndCo.snowretailing.dal.contracts.entities.IOrderEntity;
import shlackAndCo.snowretailing.dal.contracts.repositories.IBrandRepository;
import shlackAndCo.snowretailing.dal.contracts.repositories.IOrderRepository;
import shlackAndCo.snowretailing.dal.entities.BrandEntity;
import shlackAndCo.snowretailing.dal.entities.OrderEntity;

@Repository
public class OrderRepository extends BaseRepository<IOrderEntity> implements IOrderRepository {

    public OrderRepository() {
        super(OrderEntity.class);
    }
}
