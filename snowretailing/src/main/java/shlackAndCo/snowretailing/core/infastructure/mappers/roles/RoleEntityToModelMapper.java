package shlackAndCo.snowretailing.core.infastructure.mappers.roles;

import shlackAndCo.snowretailing.core.contracts.infastructure.mappers.IMapper;
import shlackAndCo.snowretailing.core.contracts.models.IRoleModel;
import shlackAndCo.snowretailing.core.models.RoleModel;
import shlackAndCo.snowretailing.dal.contracts.entities.IRoleEntity;

public class RoleEntityToModelMapper implements IMapper<IRoleEntity,IRoleModel> {
    private final static IMapper<IRoleEntity,IRoleModel> mapper = new RoleEntityToModelMapper();

    private RoleEntityToModelMapper(){}

    @Override
    public IRoleModel Map(IRoleEntity sourceValue) {
        if (sourceValue == null)
            return null;

        return new RoleModel(sourceValue);
    }

    public static IMapper<IRoleEntity,IRoleModel> getInstance(){
        return mapper;
    }
}
