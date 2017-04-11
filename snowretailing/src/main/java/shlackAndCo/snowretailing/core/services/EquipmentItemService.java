package shlackAndCo.snowretailing.core.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import shlackAndCo.snowretailing.core.contracts.infastructure.mappers.IMapper;
import shlackAndCo.snowretailing.core.contracts.models.IEquipmentItemModel;
import shlackAndCo.snowretailing.core.contracts.services.IEquipmentItemService;
import shlackAndCo.snowretailing.dal.contracts.entities.IEquipmentItemEntity;
import shlackAndCo.snowretailing.dal.contracts.repositories.IEquipmentItemRepository;

@Service
public class EquipmentItemService extends BaseService<IEquipmentItemModel, IEquipmentItemEntity> implements IEquipmentItemService{
    private final IEquipmentItemRepository equipmentItemRepository;
    private final IMapper<IEquipmentItemEntity, IEquipmentItemModel> mapper;

    @Autowired
    public EquipmentItemService(@Qualifier("equipmentItemRepository") IEquipmentItemRepository equipmentItemRepository,
                       @Qualifier("equipmentItemModelToEntityMapper") IMapper<IEquipmentItemModel, IEquipmentItemEntity> equipmentItemModelToEntityMapper,
                       @Qualifier("equipmentItemEntityToModelMapper") IMapper<IEquipmentItemEntity, IEquipmentItemModel> equipmentItemEntityToModelMapper) {
        super(equipmentItemRepository, equipmentItemModelToEntityMapper, equipmentItemEntityToModelMapper);
        this.equipmentItemRepository = equipmentItemRepository;
        mapper = equipmentItemEntityToModelMapper;
    }
}

