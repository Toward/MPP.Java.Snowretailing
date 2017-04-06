package shlackAndCo.snowretailing.core.infastructure.mappers.rent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import shlackAndCo.snowretailing.core.contracts.infastructure.mappers.IMapper;
import shlackAndCo.snowretailing.core.contracts.models.IRentModel;
import shlackAndCo.snowretailing.dal.contracts.entities.IRentEntity;
import shlackAndCo.snowretailing.dal.contracts.repositories.ICredentialRepository;
import shlackAndCo.snowretailing.dal.contracts.repositories.IEquipmentItemRepository;
import shlackAndCo.snowretailing.dal.entities.CredentialEntity;
import shlackAndCo.snowretailing.dal.entities.EquipmentItemEntity;
import shlackAndCo.snowretailing.dal.entities.RentEntity;

@Component
@Scope("singleton")
public class RentModelToEntityMapper implements IMapper<IRentModel, IRentEntity> {
    private final ICredentialRepository credentialRepository;
    private final IEquipmentItemRepository equipmentItemRepository;

    @Autowired
    public RentModelToEntityMapper(@Qualifier("credentialRepository") ICredentialRepository credentialRepository,
                                   @Qualifier("equipmentItemRepository")IEquipmentItemRepository equipmentItemRepository){
        this.credentialRepository = credentialRepository;
        this.equipmentItemRepository = equipmentItemRepository;
    }

    @Override
    public IRentEntity Map(IRentModel sourceValue) {
        if (sourceValue == null)
            return null;

        IRentEntity entity = new RentEntity();
        entity.setId(sourceValue.getId());
        entity.setDateExpectedReturn(sourceValue.getDateExpectedReturn());
        entity.setDateFactReturn(sourceValue.getDateFactReturn());
        entity.setDateGet(sourceValue.getDateGet());
        entity.setCredentialByCredentialId((CredentialEntity) credentialRepository.getById(sourceValue.getId()));
        entity.setEquipmentItemByEquipmentItemId((EquipmentItemEntity) equipmentItemRepository.getById(sourceValue.getId()));
        return entity;
    }
}
