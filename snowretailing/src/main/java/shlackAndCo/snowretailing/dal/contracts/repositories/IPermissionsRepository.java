package shlackAndCo.snowretailing.dal.contracts.repositories;

import org.osgi.service.component.annotations.Component;
import shlackAndCo.snowretailing.dal.contracts.entities.IPermissionsEntity;


@Component
public interface IPermissionsRepository extends IBaseRepository<IPermissionsEntity> {
}
