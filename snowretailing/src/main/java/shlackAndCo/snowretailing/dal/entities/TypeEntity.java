package shlackAndCo.snowretailing.dal.entities;

import shlackAndCo.snowretailing.dal.contracts.entities.ITypeEntity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "type", schema = "snowretailing_db")
public class TypeEntity implements ITypeEntity {
    private int id;
    private Enum name;
    private int cost;
    private Collection<EquipmentEntity> equipmentsById;

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
    @Column(name = "COST", nullable = false)
    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TypeEntity that = (TypeEntity) o;

        if (id != that.id) return false;
        if (cost != that.cost) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + cost;
        return result;
    }

    @OneToMany(mappedBy = "typeByTypeId")
    public Collection<EquipmentEntity> getEquipmentsById() {
        return equipmentsById;
    }

    public void setEquipmentsById(Collection<EquipmentEntity> equipmentsById) {
        this.equipmentsById = equipmentsById;
    }
}
