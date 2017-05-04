package shlackAndCo.snowretailing.core.infastructure.mappers.rent;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import shlackAndCo.snowretailing.core.contracts.infastructure.mappers.IMapper;
import shlackAndCo.snowretailing.core.contracts.models.IRentReadModel;
import shlackAndCo.snowretailing.core.models.RentReadModel;
import shlackAndCo.snowretailing.dal.contracts.entities.IRentEntity;

@Component
@Scope("singleton")
public class RentEntityToReadModelMapper implements IMapper<IRentEntity,IRentReadModel> {
    @Override
    public IRentReadModel Map(IRentEntity sourceValue) {
        if (sourceValue == null)
            return null;

        return new RentReadModel(sourceValue);
    }
}
