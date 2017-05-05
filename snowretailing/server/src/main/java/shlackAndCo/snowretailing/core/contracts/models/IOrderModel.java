package shlackAndCo.snowretailing.core.contracts.models;


import shlackAndCo.snowretailing.core.models.EquipmentItemModel;

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
//    void setEquipmentItem(IEquipmentItemModel equipmentItem);

    void setEquipmentItem(EquipmentItemModel equipmentItem);

    String getUserName();
    void setUserName(String name);
}
