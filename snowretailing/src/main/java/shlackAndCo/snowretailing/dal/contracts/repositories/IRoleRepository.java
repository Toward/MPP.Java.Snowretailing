package shlackAndCo.snowretailing.dal.contracts.repositories;

import org.osgi.service.component.annotations.Component;
import shlackAndCo.snowretailing.dal.contracts.entities.IRoleEntity;

@Component
public interface IRoleRepository extends IBaseRepository<IRoleEntity> {
    IRoleEntity getByRoleName(String roleName);
}
