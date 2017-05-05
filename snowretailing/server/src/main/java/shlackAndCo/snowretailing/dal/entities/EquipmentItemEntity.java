package shlackAndCo.snowretailing.dal.entities;

import org.hibernate.annotations.GenericGenerator;
import shlackAndCo.snowretailing.dal.contracts.entities.IEquipmentItemEntity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "equipment_item", schema = "snowretailing_db")
public class EquipmentItemEntity implements IEquipmentItemEntity{
    private int id;
    private byte deleted;
    private byte state;
    private String inventory_number;
    private EquipmentEntity equipmentByEquipmentId;
    private Collection<OrderEntity> ordersById;
    private Collection<RentEntity> rentsById;

    @Basic
    @Column(name = "state", nullable = false)
    public byte getState() {
        return state;
    }

    public void setState(byte state) {
        this.state = state;
    }
    @Basic
    @Column(name = "inventory_number", nullable = false)
    public String getInventoryNumber() {
        return inventory_number;
    }

    public void setInventoryNumber(String inventory_number) {
        this.inventory_number = inventory_number;
    }


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
        if (state != that.state) return false;
        if (inventory_number != null ? !inventory_number.equals(that.inventory_number) : that.inventory_number != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (int) deleted;
        result = 31 * result + (inventory_number != null ? inventory_number.hashCode() : 0);
        result = 31 * result + (int)state;
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
