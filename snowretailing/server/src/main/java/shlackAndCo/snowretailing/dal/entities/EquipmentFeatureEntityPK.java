package shlackAndCo.snowretailing.dal.entities;

import shlackAndCo.snowretailing.dal.contracts.entities.IEquipmentFeatureEntityPK;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class EquipmentFeatureEntityPK implements IEquipmentFeatureEntityPK {
    private int idEquipment;
    private int idCharacteristics;

    @Column(name = "ID_EQUIPMENT", nullable = false, updatable = false, insertable = false)
    @Id
    public int getIdEquipment() {
        return idEquipment;
    }

    public void setIdEquipment(int idEquipment) {
        this.idEquipment = idEquipment;
    }

    @Column(name = "ID_CHARACTERISTICS", nullable = false,updatable = false, insertable = false)
    @Id
    public int getIdCharacteristics() {
        return idCharacteristics;
    }

    public void setIdCharacteristics(int idCharacteristics) {
        this.idCharacteristics = idCharacteristics;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EquipmentFeatureEntityPK that = (EquipmentFeatureEntityPK) o;

        if (idEquipment != that.idEquipment) return false;
        if (idCharacteristics != that.idCharacteristics) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idEquipment;
        result = 31 * result + idCharacteristics;
        return result;
    }
}
