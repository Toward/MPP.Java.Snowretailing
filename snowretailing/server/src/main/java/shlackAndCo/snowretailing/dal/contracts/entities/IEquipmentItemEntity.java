package shlackAndCo.snowretailing.dal.contracts.entities;

import shlackAndCo.snowretailing.dal.entities.EquipmentEntity;
import shlackAndCo.snowretailing.dal.entities.OrderEntity;
import shlackAndCo.snowretailing.dal.entities.RentEntity;

import javax.persistence.*;
import java.util.Collection;

public interface IEquipmentItemEntity {

    public int getId();

    public void setId(int id);

    public byte getDeleted();

    public void setDeleted(byte deleted);

    public byte getState();

    public void setState(byte state);

    public String getInventoryNumber();

    public void setInventoryNumber(String inventoryNumber);

    public EquipmentEntity getEquipmentByEquipmentId();

    public void setEquipmentByEquipmentId(EquipmentEntity equipmentByEquipmentId);

    public Collection<OrderEntity> getOrdersById();

    public void setOrdersById(Collection<OrderEntity> ordersById);

    public Collection<RentEntity> getRentsById();

    public void setRentsById(Collection<RentEntity> rentsById);
}
