package shlackAndCo.snowretailing.dal.contracts.repositories;

import org.osgi.service.component.annotations.Component;
import shlackAndCo.snowretailing.dal.contracts.entities.IUserEntity;


@Component
public interface IUserRepository extends IBaseRepository<IUserEntity> {
}
