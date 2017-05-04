package shlackAndCo.snowretailing.core.contracts.models;

import shlackAndCo.snowretailing.dal.entities.EquipmentEntity;
import shlackAndCo.snowretailing.dal.entities.OrderEntity;
import shlackAndCo.snowretailing.dal.entities.RentEntity;

import java.util.Collection;

public interface IEquipmentItemModel extends IBaseModel {

    byte getDeleted();

    void setDeleted(byte deleted);

    public byte getState();
    public void setState(byte state);

    public String getInventory_number() ;

    public void setInventory_number(String inventory_number);
}
