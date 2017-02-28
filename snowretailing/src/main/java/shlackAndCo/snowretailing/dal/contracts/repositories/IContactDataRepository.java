package shlackAndCo.snowretailing.dal.contracts.repositories;

import org.osgi.service.component.annotations.Component;
import shlackAndCo.snowretailing.dal.contracts.entities.IContactDataEntity;

@Component
public interface IContactDataRepository extends IBaseRepository<IContactDataEntity> {
}
