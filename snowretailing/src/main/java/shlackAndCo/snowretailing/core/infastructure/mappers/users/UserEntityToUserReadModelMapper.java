package shlackAndCo.snowretailing.core.infastructure.mappers.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import shlackAndCo.snowretailing.core.contracts.infastructure.mappers.IMapper;
import shlackAndCo.snowretailing.core.contracts.models.IRoleModel;
import shlackAndCo.snowretailing.core.contracts.models.IUserReadModel;
import shlackAndCo.snowretailing.core.models.UserReadModel;
import shlackAndCo.snowretailing.dal.contracts.entities.IRoleEntity;
import shlackAndCo.snowretailing.dal.contracts.entities.IUserEntity;

@Component
@Scope("singleton")
public class UserEntityToUserReadModelMapper implements IMapper<IUserEntity, IUserReadModel> {
    private final IMapper<IRoleEntity, IRoleModel> roleMapper;

    @Autowired
    public UserEntityToUserReadModelMapper(@Qualifier("roleEntityToModelMapper")IMapper<IRoleEntity, IRoleModel> roleMapper){
        this.roleMapper = roleMapper;
    }

    @Override
    public IUserReadModel Map(IUserEntity sourceValue) {
        if(sourceValue == null)
            return null;

        IUserReadModel result = new UserReadModel();
        result.setId(sourceValue.getId());
        result.setLogin(sourceValue.getLogin());
        result.setRole(roleMapper.Map(sourceValue.getRoleByRoleId()));
        return result;
    }
}
 