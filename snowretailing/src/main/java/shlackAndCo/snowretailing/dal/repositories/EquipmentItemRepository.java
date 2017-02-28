package shlackAndCo.snowretailing.dal.repositories;

import org.springframework.stereotype.Repository;
import shlackAndCo.snowretailing.dal.contracts.entities.IBrandEntity;
import shlackAndCo.snowretailing.dal.contracts.entities.IEquipmentItemEntity;
import shlackAndCo.snowretailing.dal.contracts.repositories.IBrandRepository;
import shlackAndCo.snowretailing.dal.contracts.repositories.IEquipmentItemRepository;
import shlackAndCo.snowretailing.dal.entities.BrandEntity;
import shlackAndCo.snowretailing.dal.entities.EquipmentItemEntity;

@Repository
public class EquipmentItemRepository extends BaseRepository<IEquipmentItemEntity> implements IEquipmentItemRepository {

    public EquipmentItemRepository() {
        super(EquipmentItemEntity.class);
    }
}
