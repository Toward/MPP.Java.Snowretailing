package shlackAndCo.snowretailing.core.infastructure.mappers.order;


import org.springframework.context.annotation.Scope;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import shlackAndCo.snowretailing.core.contracts.infastructure.mappers.IMapper;
import shlackAndCo.snowretailing.core.contracts.models.IOrderModel;
import shlackAndCo.snowretailing.core.models.OrderModel;
import shlackAndCo.snowretailing.dal.contracts.entities.IOrderEntity;
import shlackAndCo.snowretailing.dal.entities.EquipmentEntity;
import shlackAndCo.snowretailing.dal.entities.EquipmentItemEntity;
import shlackAndCo.snowretailing.dal.entities.OrderEntity;
import shlackAndCo.snowretailing.dal.entities.UserEntity;
import shlackAndCo.snowretailing.dal.repositories.EquipmentItemRepository;
import shlackAndCo.snowretailing.dal.repositories.EquipmentRepository;
import shlackAndCo.snowretailing.dal.repositories.UserRepository;

@Component
@Scope("singleton")
public class OrderModelToEntityMapper implements IMapper<IOrderModel, IOrderEntity> {
    @Override
    public IOrderEntity Map(IOrderModel sourceValue) {
        if (sourceValue == null)
            return null;

        IOrderEntity entity = new OrderEntity();
        entity.setId(sourceValue.getId());
        entity.setDateOrder(sourceValue.getDateOrder());
        entity.setDateOrderExpire(sourceValue.getDateOrderExpire());
        entity.setSumPay(sourceValue.getSumPay());
        entity.setState(sourceValue.getState());
        UserEntity user = (UserEntity)new UserRepository().getByLogin(sourceValue.getUserName());
        if(user == null)
            throw new IllegalArgumentException("User with name" + user.getLogin()+ "doesn't exist");
        entity.setUserByUserId(user);
        EquipmentItemEntity item = (EquipmentItemEntity) new EquipmentItemRepository().getById(sourceValue.getEquipmentItem().getId());
        if(item == null)
            throw new IllegalArgumentException("Item with id" + item.getId()+ "doesn't exist");
        entity.setEquipmentItemByItemId(item);
        return entity;
    }
}
