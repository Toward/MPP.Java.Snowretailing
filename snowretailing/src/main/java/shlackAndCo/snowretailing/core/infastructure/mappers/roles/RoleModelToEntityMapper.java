package shlackAndCo.snowretailing.core.infastructure.mappers.roles;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import shlackAndCo.snowretailing.core.contracts.infastructure.mappers.IMapper;
import shlackAndCo.snowretailing.core.contracts.models.IRoleModel;
import shlackAndCo.snowretailing.dal.contracts.entities.IRoleEntity;
import shlackAndCo.snowretailing.dal.entities.RoleEntity;

@Component
@Scope("singleton")
public class RoleModelToEntityMapper implements IMapper<IRoleModel, IRoleEntity> {
    @Override
    public IRoleEntity Map(IRoleModel sourceValue) {
        if (sourceValue == null)
            return null;

        IRoleEntity entity = new RoleEntity();
        entity.setId(sourceValue.getId());
        entity.setRoleName(sourceValue.getRoleName());
        return entity;
    }
}
