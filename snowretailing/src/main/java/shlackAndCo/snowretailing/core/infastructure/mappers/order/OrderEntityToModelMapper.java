package shlackAndCo.snowretailing.core.infastructure.mappers.order;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import shlackAndCo.snowretailing.core.contracts.infastructure.mappers.IMapper;
import shlackAndCo.snowretailing.core.contracts.models.IOrderModel;
import shlackAndCo.snowretailing.core.models.OrderModel;
import shlackAndCo.snowretailing.dal.contracts.entities.IOrderEntity;

@Component
@Scope("singleton")
public class OrderEntityToModelMapper implements IMapper<IOrderEntity,IOrderModel> {
    @Override
    public IOrderModel Map(IOrderEntity sourceValue) {
        if (sourceValue == null)
            return null;

        return new OrderModel(sourceValue);
    }
}
