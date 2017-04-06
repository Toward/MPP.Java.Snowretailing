package shlackAndCo.snowretailing.core.infastructure.mappers.rent;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import shlackAndCo.snowretailing.core.contracts.infastructure.mappers.IMapper;
import shlackAndCo.snowretailing.core.contracts.models.IRentModel;
import shlackAndCo.snowretailing.dal.contracts.entities.IRentEntity;
import shlackAndCo.snowretailing.dal.entities.CredentialEntity;
import shlackAndCo.snowretailing.dal.entities.EquipmentItemEntity;
import shlackAndCo.snowretailing.dal.entities.RentEntity;
import shlackAndCo.snowretailing.dal.repositories.CredentialRepository;
import shlackAndCo.snowretailing.dal.repositories.EquipmentItemRepository;
import shlackAndCo.snowretailing.dal.repositories.EquipmentRepository;

@Component
@Scope("singleton")
public class RentModelToEntityMapper implements IMapper<IRentModel, IRentEntity> {
    @Override
    public IRentEntity Map(IRentModel sourceValue) {
        if (sourceValue == null)
            return null;

        IRentEntity entity = new RentEntity();
        entity.setId(sourceValue.getId());
        entity.setDateExpectedReturn(sourceValue.getDateExpectedReturn());
        entity.setDateFactReturn(sourceValue.getDateFactReturn());
        entity.setDateGet(sourceValue.getDateGet());
        entity.setCredentialByCredentialId((CredentialEntity) new CredentialRepository().getById(sourceValue.getId()));
        entity.setEquipmentItemByEquipmentItemId((EquipmentItemEntity) new EquipmentItemRepository().getById(sourceValue.getId()));
        return entity;
    }
}
