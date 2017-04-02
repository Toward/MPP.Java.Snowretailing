package shlackAndCo.snowretailing.core.infastructure.mappers.users;

import shlackAndCo.snowretailing.core.contracts.infastructure.mappers.IMapper;
import shlackAndCo.snowretailing.core.contracts.models.IUserModel;
import shlackAndCo.snowretailing.core.models.UserModel;
import shlackAndCo.snowretailing.dal.contracts.entities.IUserEntity;

public class UserEntityToModelMapper implements IMapper<IUserEntity, IUserModel> {
    private final static IMapper<IUserEntity,IUserModel> mapper = new UserEntityToModelMapper();

    private UserEntityToModelMapper(){}

    @Override
    public IUserModel Map(IUserEntity sourceValue) {
        if(sourceValue == null)
            return null;

        return new UserModel(sourceValue);
    }

    public static IMapper<IUserEntity,IUserModel> getInstance(){
        return mapper;
    }
}
 