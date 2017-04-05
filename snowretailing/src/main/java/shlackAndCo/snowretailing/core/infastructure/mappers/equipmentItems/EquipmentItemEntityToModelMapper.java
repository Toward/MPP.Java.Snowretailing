package shlackAndCo.snowretailing.core.infastructure.mappers.equipmentItems;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import shlackAndCo.snowretailing.core.contracts.infastructure.mappers.IMapper;
import shlackAndCo.snowretailing.core.contracts.models.IEquipmentItemModel;
import shlackAndCo.snowretailing.core.models.EquipmentItemModel;
import shlackAndCo.snowretailing.dal.contracts.entities.IEquipmentItemEntity;

@Component
@Scope("singleton")
public class EquipmentItemEntityToModelMapper implements IMapper<IEquipmentItemEntity,IEquipmentItemModel> {
    @Override
    public IEquipmentItemModel Map(IEquipmentItemEntity sourceValue) {
        if (sourceValue == null)
            return null;

        return new EquipmentItemModel(sourceValue);
    }
}
