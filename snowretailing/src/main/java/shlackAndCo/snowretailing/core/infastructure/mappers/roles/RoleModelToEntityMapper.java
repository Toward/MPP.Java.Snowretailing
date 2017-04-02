package shlackAndCo.snowretailing.core.infastructure.mappers.roles;

import shlackAndCo.snowretailing.core.contracts.infastructure.mappers.IMapper;
import shlackAndCo.snowretailing.core.contracts.models.IRoleModel;
import shlackAndCo.snowretailing.dal.contracts.entities.IRoleEntity;
import shlackAndCo.snowretailing.dal.entities.RoleEntity;

public class RoleModelToEntityMapper implements IMapper<IRoleModel, IRoleEntity> {
    private final static IMapper<IRoleModel, IRoleEntity> mapper = new RoleModelToEntityMapper();

    private RoleModelToEntityMapper(){}

    @Override
    public IRoleEntity Map(IRoleModel sourceValue) {
        if (sourceValue == null)
            return null;

        IRoleEntity entity = new RoleEntity();
        entity.setId(sourceValue.getId());
        entity.setRoleName(sourceValue.getRoleName());
        return entity;
    }

    public static IMapper<IRoleModel, IRoleEntity> getInstance(){
        return mapper;
    }
}
