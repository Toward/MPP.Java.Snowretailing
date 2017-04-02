package shlackAndCo.snowretailing.core.infastructure.mappers.users;

import shlackAndCo.snowretailing.core.contracts.infastructure.mappers.IMapper;
import shlackAndCo.snowretailing.core.contracts.models.IRoleModel;
import shlackAndCo.snowretailing.core.contracts.models.IUserModel;
import shlackAndCo.snowretailing.core.infastructure.mappers.roles.RoleModelToEntityMapper;
import shlackAndCo.snowretailing.dal.contracts.entities.IRoleEntity;
import shlackAndCo.snowretailing.dal.contracts.entities.IUserEntity;
import shlackAndCo.snowretailing.dal.entities.RoleEntity;
import shlackAndCo.snowretailing.dal.entities.UserEntity;

public class UserModelToEntityMapper implements IMapper<IUserModel, IUserEntity> {
    private final static IMapper<IUserModel, IUserEntity> mapper = new UserModelToEntityMapper();
    private final IMapper<IRoleModel, IRoleEntity> roleModelToEntityMapper;

    private UserModelToEntityMapper(){
        roleModelToEntityMapper = RoleModelToEntityMapper.getInstance();
    }

    @Override
    public IUserEntity Map(IUserModel sourceValue) {
        if(sourceValue == null)
            return null;

        IUserEntity entity = new UserEntity();
        entity.setId(sourceValue.getId());
        entity.setLogin(sourceValue.getLogin());
        entity.setPasswordHash(sourceValue.getPasswordHash());

        entity.setRoleByRoleId((RoleEntity) roleModelToEntityMapper.Map(sourceValue.getRole()));
        return entity;
    }

    public static IMapper<IUserModel, IUserEntity> getInstance(){
        return mapper;
    }
}
