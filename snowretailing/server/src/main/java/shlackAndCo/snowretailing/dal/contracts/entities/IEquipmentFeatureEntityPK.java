package shlackAndCo.snowretailing.dal.contracts.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public interface IEquipmentFeatureEntityPK extends Serializable {

    public int getIdEquipment();

    public void setIdEquipment(int idEquipment);

    public int getIdCharacteristics();

    public void setIdCharacteristics(int idCharacteristics);

}
