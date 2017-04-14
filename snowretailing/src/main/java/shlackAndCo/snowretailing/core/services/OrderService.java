package shlackAndCo.snowretailing.core.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import shlackAndCo.snowretailing.core.contracts.infastructure.mappers.IMapper;
import shlackAndCo.snowretailing.core.contracts.models.IOrderModel;
import shlackAndCo.snowretailing.core.contracts.services.IOrderService;
import shlackAndCo.snowretailing.dal.contracts.entities.IOrderEntity;
import shlackAndCo.snowretailing.dal.contracts.repositories.IOrderRepository;

import java.util.Collection;

@Service
public class OrderService extends BaseService<IOrderModel, IOrderEntity> implements IOrderService {
    private final IOrderRepository orderRepository;
    private final IMapper<IOrderEntity, IOrderModel> mapper;

    @Autowired
    public OrderService(@Qualifier("orderRepository") IOrderRepository orderRepository,
                                @Qualifier("orderModelToEntityMapper") IMapper<IOrderModel, IOrderEntity> orderModelToEntityMapper,
                                @Qualifier("orderEntityToModelMapper") IMapper<IOrderEntity, IOrderModel> orderEntityToModelMapper) {
        super(orderRepository, orderModelToEntityMapper, orderEntityToModelMapper);
        this.orderRepository = orderRepository;
        mapper = orderEntityToModelMapper;
    }


    @Override
    public Collection<IOrderModel> getUsersOrders(String userName) {
        return null;
    }
}