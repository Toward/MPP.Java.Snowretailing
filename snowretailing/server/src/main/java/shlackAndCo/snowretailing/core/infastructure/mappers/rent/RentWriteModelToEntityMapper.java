package shlackAndCo.snowretailing.core.infastructure.mappers.rent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import shlackAndCo.snowretailing.core.contracts.infastructure.mappers.IMapper;
import shlackAndCo.snowretailing.core.contracts.models.IRentWriteModel;
import shlackAndCo.snowretailing.dal.contracts.entities.IRentEntity;
import shlackAndCo.snowretailing.dal.contracts.repositories.ICredentialRepository;
import shlackAndCo.snowretailing.dal.contracts.repositories.IEquipmentItemRepository;
import shlackAndCo.snowretailing.dal.entities.CredentialEntity;
import shlackAndCo.snowretailing.dal.entities.EquipmentItemEntity;
import shlackAndCo.snowretailing.dal.entities.RentEntity;

@Component
@Scope("singleton")
public class RentWriteModelToEntityMapper implements IMapper<IRentWriteModel, IRentEntity> {
    private final ICredentialRepository credentialRepository;
    private final IEquipmentItemRepository equipmentItemRepository;

    @Autowired
    public RentWriteModelToEntityMapper(@Qualifier("credentialRepository") ICredentialRepository credentialRepository,
                                        @Qualifier("equipmentItemRepository")IEquipmentItemRepository equipmentItemRepository){
        this.credentialRepository = credentialRepository;
        this.equipmentItemRepository = equipmentItemRepository;
    }

    @Override
    public IRentEntity Map(IRentWriteModel sourceValue) {
        if (sourceValue == null)
            return null;

        IRentEntity entity = new RentEntity();
        entity.setId(sourceValue.getId());
        entity.setDateExpectedReturn(sourceValue.getDateExpectedReturn());
        entity.setDateFactReturn(sourceValue.getDateFactReturn());
        entity.setDateGet(sourceValue.getDateGet());
        CredentialEntity credentialEntity = (CredentialEntity) credentialRepository.getById(sourceValue.getCredentialId());
        if(credentialEntity == null)
            throw new IllegalArgumentException("Credential with id" + sourceValue.getCredentialId()+ "doesn't exist");
        entity.setCredentialByCredentialId(credentialEntity);
        EquipmentItemEntity equipmentItemEntity = (EquipmentItemEntity) equipmentItemRepository.getById(sourceValue.getEquipmentItemId());
        if(equipmentItemEntity == null)
            throw new IllegalArgumentException("Equipment items with id" + sourceValue.getEquipmentItemId()+ "doesn't exist");
        entity.setEquipmentItemByEquipmentItemId((EquipmentItemEntity) equipmentItemRepository.getById(sourceValue.getId()));
        return entity;
    }
}
