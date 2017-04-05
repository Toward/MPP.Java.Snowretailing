package shlackAndCo.snowretailing.core.infastructure.mappers.users;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import shlackAndCo.snowretailing.core.contracts.infastructure.mappers.IMapper;
import shlackAndCo.snowretailing.core.contracts.models.IUserModel;
import shlackAndCo.snowretailing.dal.contracts.entities.IUserEntity;
import shlackAndCo.snowretailing.dal.entities.RoleEntity;
import shlackAndCo.snowretailing.dal.entities.UserEntity;

@Component
@Scope("singleton")
public class UserModelToEntityMapper implements IMapper<IUserModel, IUserEntity> {
    @Override
    public IUserEntity Map(IUserModel sourceValue) {
        if(sourceValue == null)
            return null;

        IUserEntity entity = new UserEntity();
        entity.setId(sourceValue.getId());
        entity.setLogin(sourceValue.getLogin());
        entity.setPasswordHash(sourceValue.getPasswordHash());


        RoleEntity role = new RoleEntity();
        role.setId(sourceValue.getRoleId());
        entity.setRoleByRoleId(role);
        return entity;
    }
}
