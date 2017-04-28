package shlackAndCo.snowretailing.core.infastructure.mappers.roles;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import shlackAndCo.snowretailing.core.contracts.infastructure.mappers.IMapper;
import shlackAndCo.snowretailing.core.contracts.models.IRoleModel;
import shlackAndCo.snowretailing.core.models.RoleModel;
import shlackAndCo.snowretailing.dal.contracts.entities.IRoleEntity;

@Component
@Scope("singleton")
public class RoleEntityToModelMapper implements IMapper<IRoleEntity,IRoleModel> {
    @Override
    public IRoleModel Map(IRoleEntity sourceValue) {
        if (sourceValue == null)
            return null;

        return new RoleModel(sourceValue);
    }
}
