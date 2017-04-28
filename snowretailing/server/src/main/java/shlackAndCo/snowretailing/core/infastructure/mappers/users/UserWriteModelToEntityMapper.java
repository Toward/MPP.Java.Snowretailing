package shlackAndCo.snowretailing.core.infastructure.mappers.users;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import shlackAndCo.snowretailing.core.contracts.infastructure.mappers.IMapper;
import shlackAndCo.snowretailing.core.contracts.models.IUserWriteModel;
import shlackAndCo.snowretailing.dal.contracts.entities.IUserEntity;
import shlackAndCo.snowretailing.dal.entities.RoleEntity;
import shlackAndCo.snowretailing.dal.entities.UserEntity;

@Component
@Scope("singleton")
public class UserWriteModelToEntityMapper implements IMapper<IUserWriteModel, IUserEntity> {

    @Override
    public IUserEntity Map(IUserWriteModel sourceValue) {
        if(sourceValue == null)
            return null;

        RoleEntity role = new RoleEntity();
        role.setId(sourceValue.getRoleId());

        IUserEntity entity = new UserEntity();
        entity.setId(sourceValue.getId());
        entity.setLogin(sourceValue.getLogin());
        entity.setPasswordHash(DigestUtils.md5Hex(sourceValue.getPassword()));
        entity.setRoleByRoleId(role);
        return entity;
    }
}
