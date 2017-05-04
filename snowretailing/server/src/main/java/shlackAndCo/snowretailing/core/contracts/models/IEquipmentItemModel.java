package shlackAndCo.snowretailing.core.contracts.models;

public interface IEquipmentItemModel extends IBaseModel {
    byte getDeleted();
    void setDeleted(byte deleted);

    byte getState();
    void setState(byte state);

    String getInventory_number() ;
    void setInventory_number(String inventory_number);
}
