package shlackAndCo.snowretailing.core.infastructure.mappers.users;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import shlackAndCo.snowretailing.core.contracts.infastructure.mappers.IMapper;
import shlackAndCo.snowretailing.core.contracts.models.IUserModel;
import shlackAndCo.snowretailing.core.models.UserModel;
import shlackAndCo.snowretailing.dal.contracts.entities.IUserEntity;

@Component
@Scope("singleton")
public class UserEntityToModelMapper implements IMapper<IUserEntity, IUserModel> {
    @Override
    public IUserModel Map(IUserEntity sourceValue) {
        if(sourceValue == null)
            return null;

        return new UserModel(sourceValue);
    }
}
 