package shlackAndCo.snowretailing.dal.contracts.entities;

import shlackAndCo.snowretailing.dal.entities.*;
import shlackAndCo.snowretailing.dal.enums.CharacteristicsMeasurments;
import shlackAndCo.snowretailing.dal.enums.CharacteristicsNames;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Collection;

/**
 * Created by Владелец on 28/02/2017.
 */
@Entity
@Table(name = "characteristics", schema = "snowretailing_db")
public interface ICharacteristicsEntity {
    public int getId();

    public void setId(int id);

    public CharacteristicsNames getName();

    public void setName(CharacteristicsNames name);

    public CharacteristicsMeasurments getMeasurment();

    public void setMeasurment(CharacteristicsMeasurments measurment);

    public Collection<EquipmentFeatureEntity> getEquipmentFeaturesById();

    public void setEquipmentFeaturesById(Collection<EquipmentFeatureEntity> equipmentFeaturesById);
}
