package shlackAndCo.snowretailing.dal.contracts.repositories;

import org.osgi.service.component.annotations.Component;
import shlackAndCo.snowretailing.dal.contracts.entities.IRentEntity;


@Component
public interface IRentRepository extends IBaseRepository<IRentEntity> {
}
