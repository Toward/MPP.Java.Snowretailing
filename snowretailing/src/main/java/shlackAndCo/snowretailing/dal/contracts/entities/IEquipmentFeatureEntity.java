package shlackAndCo.snowretailing.dal.contracts.entities;

import shlackAndCo.snowretailing.dal.entities.*;

import javax.persistence.*;

public interface IEquipmentFeatureEntity {

    public int getIdEquipment();

    public void setIdEquipment(int idEquipment);

    public int getIdCharacteristics();

    public void setIdCharacteristics(int idCharacteristics);

    public String getValue();

    public void setValue(String value);

    public EquipmentEntity getEquipmentByIdEquipment();

    public void setEquipmentByIdEquipment(EquipmentEntity equipmentByIdEquipment);

    public CharacteristicsEntity getCharacteristicsByIdCharacteristics();

    public void setCharacteristicsByIdCharacteristics(CharacteristicsEntity characteristicsByIdCharacteristics);
}
