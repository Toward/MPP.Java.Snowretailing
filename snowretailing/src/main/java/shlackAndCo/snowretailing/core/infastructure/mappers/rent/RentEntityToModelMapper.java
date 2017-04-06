package shlackAndCo.snowretailing.core.infastructure.mappers.rent;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import shlackAndCo.snowretailing.core.contracts.infastructure.mappers.IMapper;
import shlackAndCo.snowretailing.core.contracts.models.IRentModel;
import shlackAndCo.snowretailing.core.models.RentModel;
import shlackAndCo.snowretailing.dal.contracts.entities.IRentEntity;

@Component
@Scope("singleton")
public class RentEntityToModelMapper implements IMapper<IRentEntity,IRentModel> {
    @Override
    public IRentModel Map(IRentEntity sourceValue) {
        if (sourceValue == null)
            return null;

        return new RentModel(sourceValue);
    }
}
