package shlackAndCo.snowretailing.dal.contracts.repositories;

import org.osgi.service.component.annotations.Component;
import shlackAndCo.snowretailing.dal.contracts.entities.IOrderEntity;


@Component
public interface IOrderRepository extends IBaseRepository<IOrderEntity> {
}
