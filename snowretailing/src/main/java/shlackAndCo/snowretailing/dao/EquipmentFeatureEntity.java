package shlackAndCo.snowretailing.dao;

import javax.persistence.*;

@Entity
@Table(name = "equipment_feature", schema = "snowretailing_db")
@IdClass(EquipmentFeatureEntityPK.class)
public class EquipmentFeatureEntity {
    private int idEquipment;
    private int idCharacteristics;
    private String value;
    private EquipmentEntity equipmentByIdEquipment;
    private CharacteristicsEntity characteristicsByIdCharacteristics;

    @Id
    @Column(name = "ID_EQUIPMENT", nullable = false)
    public int getIdEquipment() {
        return idEquipment;
    }

    public void setIdEquipment(int idEquipment) {
        this.idEquipment = idEquipment;
    }

    @Id
    @Column(name = "ID_CHARACTERISTICS", nullable = false)
    public int getIdCharacteristics() {
        return idCharacteristics;
    }

    public void setIdCharacteristics(int idCharacteristics) {
        this.idCharacteristics = idCharacteristics;
    }

    @Basic
    @Column(name = "VALUE", nullable = true, length = 50)
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EquipmentFeatureEntity that = (EquipmentFeatureEntity) o;

        if (idEquipment != that.idEquipment) return false;
        if (idCharacteristics != that.idCharacteristics) return false;
        if (value != null ? !value.equals(that.value) : that.value != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idEquipment;
        result = 31 * result + idCharacteristics;
        result = 31 * result + (value != null ? value.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "ID_EQUIPMENT", referencedColumnName = "ID", nullable = false)
    public EquipmentEntity getEquipmentByIdEquipment() {
        return equipmentByIdEquipment;
    }

    public void setEquipmentByIdEquipment(EquipmentEntity equipmentByIdEquipment) {
        this.equipmentByIdEquipment = equipmentByIdEquipment;
    }

    @ManyToOne
    @JoinColumn(name = "ID_CHARACTERISTICS", referencedColumnName = "ID", nullable = false)
    public CharacteristicsEntity getCharacteristicsByIdCharacteristics() {
        return characteristicsByIdCharacteristics;
    }

    public void setCharacteristicsByIdCharacteristics(CharacteristicsEntity characteristicsByIdCharacteristics) {
        this.characteristicsByIdCharacteristics = characteristicsByIdCharacteristics;
    }
}
