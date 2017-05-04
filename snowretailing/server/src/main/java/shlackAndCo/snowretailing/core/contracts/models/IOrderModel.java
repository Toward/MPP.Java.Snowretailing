package shlackAndCo.snowretailing.core.contracts.models;


import java.sql.Timestamp;

public interface IOrderModel extends IBaseModel {
    Timestamp getDateOrderExpire();
    void setDateOrderExpire(Timestamp dateOrderExpire);

    Timestamp getDateOrder();
    void setDateOrder(Timestamp dateOrder);

    byte getState();
    void setState(byte state);

    int getSumPay();
    void setSumPay(int sumPay);

    IEquipmentItemModel getEquipmentItem();
    void setEquipmentItem(IEquipmentItemModel equipmentItem);

    String getUserName();
    void setUserName(String name);
}
