package shlackAndCo.snowretailing.dal.repositories;

import org.springframework.stereotype.Repository;
import shlackAndCo.snowretailing.dal.contracts.entities.IBrandEntity;
import shlackAndCo.snowretailing.dal.contracts.entities.IEquipmentFeatureEntity;
import shlackAndCo.snowretailing.dal.contracts.repositories.IBrandRepository;
import shlackAndCo.snowretailing.dal.contracts.repositories.IEquipmentFeatureRepository;
import shlackAndCo.snowretailing.dal.entities.BrandEntity;
import shlackAndCo.snowretailing.dal.entities.EquipmentFeatureEntity;

@Repository
public class EquipmentFeatureRepository extends BaseRepository<IEquipmentFeatureEntity> implements IEquipmentFeatureRepository {

    public EquipmentFeatureRepository() {
        super(EquipmentFeatureEntity.class);
    }
}
