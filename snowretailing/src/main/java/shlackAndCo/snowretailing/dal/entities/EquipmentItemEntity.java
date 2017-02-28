package shlackAndCo.snowretailing.dal.entities;

import shlackAndCo.snowretailing.dal.contracts.entities.IEquipmentItemEntity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "equipment_item", schema = "snowretailing_db")
public class EquipmentItemEntity implements IEquipmentItemEntity{
    private int id;
    private byte deleted;
    private EquipmentEntity equipmentByEquipmentId;
    private Collection<OrderEntity> ordersById;
    private Collection<RentEntity> rentsById;

    @Id
    @Column(name = "ID", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "DELETED", nullable = false)
    public byte getDeleted() {
        return deleted;
    }

    public void setDeleted(byte deleted) {
        this.deleted = deleted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EquipmentItemEntity that = (EquipmentItemEntity) o;

        if (id != that.id) return false;
        if (deleted != that.deleted) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (int) deleted;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "EQUIPMENT_ID", referencedColumnName = "ID", nullable = false)
    public EquipmentEntity getEquipmentByEquipmentId() {
        return equipmentByEquipmentId;
    }

    public void setEquipmentByEquipmentId(EquipmentEntity equipmentByEquipmentId) {
        this.equipmentByEquipmentId = equipmentByEquipmentId;
    }

    @OneToMany(mappedBy = "equipmentItemByItemId")
    public Collection<OrderEntity> getOrdersById() {
        return ordersById;
    }

    public void setOrdersById(Collection<OrderEntity> ordersById) {
        this.ordersById = ordersById;
    }

    @OneToMany(mappedBy = "equipmentItemByEquipmentItemId")
    public Collection<RentEntity> getRentsById() {
        return rentsById;
    }

    public void setRentsById(Collection<RentEntity> rentsById) {
        this.rentsById = rentsById;
    }
}
