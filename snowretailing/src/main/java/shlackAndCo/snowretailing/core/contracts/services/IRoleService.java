package shlackAndCo.snowretailing.core.contracts.services;

import shlackAndCo.snowretailing.core.contracts.models.IRoleModel;
import shlackAndCo.snowretailing.core.services.BaseService;
import shlackAndCo.snowretailing.dal.contracts.entities.IRoleEntity;

public interface IRoleService extends IBaseService<IRoleModel>{
    IRoleModel getByRoleName(String roleName);
}
