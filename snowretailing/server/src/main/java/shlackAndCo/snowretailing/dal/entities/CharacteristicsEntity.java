package shlackAndCo.snowretailing.dal.entities;

import org.hibernate.annotations.GenericGenerator;
import shlackAndCo.snowretailing.dal.contracts.entities.ICharacteristicsEntity;
import shlackAndCo.snowretailing.dal.enums.CharacteristicsMeasurments;
import shlackAndCo.snowretailing.dal.enums.CharacteristicsNames;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "characteristics", schema = "snowretailing_db")
public class CharacteristicsEntity implements ICharacteristicsEntity {
    private int id;
    private CharacteristicsNames name;
    private CharacteristicsMeasurments measurment;
    private Collection<EquipmentFeatureEntity> equipmentFeaturesById;

    @Id
    @Column(name = "ID", nullable = false)
    @GenericGenerator(name="generator", strategy="increment")
    @GeneratedValue(generator="generator")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Enumerated(EnumType.STRING)
    @Column(name = "NAME", nullable = true)
    public CharacteristicsNames getName() {
        return name;
    }

    public void setName(CharacteristicsNames name) {
        this.name = name;
    }

    @Basic
    @Enumerated(EnumType.STRING)
    @Column(name = "MEASURMENT", nullable = true)
    public CharacteristicsMeasurments getMeasurment() {
        return measurment;
    }

    public void setMeasurment(CharacteristicsMeasurments measurment) {
        this.measurment = measurment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CharacteristicsEntity that = (CharacteristicsEntity) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (measurment != null ? !measurment.equals(that.measurment) : that.measurment != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (measurment != null ? measurment.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "characteristicsByIdCharacteristics")
    public Collection<EquipmentFeatureEntity> getEquipmentFeaturesById() {
        return equipmentFeaturesById;
    }

    public void setEquipmentFeaturesById(Collection<EquipmentFeatureEntity> equipmentFeaturesById) {
        this.equipmentFeaturesById = equipmentFeaturesById;
    }
}
