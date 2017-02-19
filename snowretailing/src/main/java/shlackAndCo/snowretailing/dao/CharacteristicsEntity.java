package shlackAndCo.snowretailing.dao;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "characteristics", schema = "snowretailing_db")
public class CharacteristicsEntity {
    private int id;
    private Enum name;
    private Enum measurment;
    private Collection<EquipmentFeatureEntity> equipmentFeaturesById;

    @Id
    @Column(name = "ID", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "NAME", nullable = true)
    public Enum getName() {
        return name;
    }

    public void setName(Enum name) {
        this.name = name;
    }

    @Basic
    @Column(name = "MEASURMENT", nullable = true)
    public Enum getMeasurment() {
        return measurment;
    }

    public void setMeasurment(Enum measurment) {
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
