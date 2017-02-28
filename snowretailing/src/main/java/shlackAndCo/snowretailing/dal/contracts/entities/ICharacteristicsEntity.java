package shlackAndCo.snowretailing.dal.contracts.entities;

import shlackAndCo.snowretailing.dal.entities.*;

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

    public Enum getName();

    public void setName(Enum name);

    public Enum getMeasurment();

    public void setMeasurment(Enum measurment);

    public Collection<EquipmentFeatureEntity> getEquipmentFeaturesById();

    public void setEquipmentFeaturesById(Collection<EquipmentFeatureEntity> equipmentFeaturesById);
}
