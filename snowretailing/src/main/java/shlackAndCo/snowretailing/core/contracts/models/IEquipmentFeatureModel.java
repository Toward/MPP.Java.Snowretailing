package shlackAndCo.snowretailing.core.contracts.models;

import shlackAndCo.snowretailing.dal.entities.*;

public interface IEquipmentFeatureModel {

    public int getIdEquipment();

    public void setIdEquipment(int idEquipment);

    public int getIdCharacteristics();

    public void setIdCharacteristics(int idCharacteristics);

    public String getValue();

    public void setValue(String value);
}
