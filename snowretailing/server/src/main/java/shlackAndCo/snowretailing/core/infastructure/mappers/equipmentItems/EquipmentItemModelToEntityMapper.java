package shlackAndCo.snowretailing.core.infastructure.mappers.equipmentItems;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import shlackAndCo.snowretailing.core.contracts.infastructure.mappers.IMapper;
import shlackAndCo.snowretailing.core.contracts.models.IEquipmentItemModel;
import shlackAndCo.snowretailing.dal.contracts.entities.IEquipmentItemEntity;
import shlackAndCo.snowretailing.dal.entities.EquipmentEntity;
import shlackAndCo.snowretailing.dal.entities.EquipmentItemEntity;
import shlackAndCo.snowretailing.dal.repositories.EquipmentRepository;

@Component
@Scope("singleton")
public class EquipmentItemModelToEntityMapper implements IMapper<IEquipmentItemModel, IEquipmentItemEntity> {
    @Override
    public IEquipmentItemEntity Map(IEquipmentItemModel sourceValue) {
        if (sourceValue == null)
            return null;

        IEquipmentItemEntity entity = new EquipmentItemEntity();
        entity.setId(sourceValue.getId());
        entity.setDeleted(sourceValue.getDeleted());
        entity.setState(sourceValue.getState());
        entity.setInventoryNumber(sourceValue.getInventory_number());
        return entity;
    }
}
