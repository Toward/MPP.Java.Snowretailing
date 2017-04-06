package shlackAndCo.snowretailing.core.contracts.models;

import shlackAndCo.snowretailing.dal.entities.EquipmentItemEntity;
import shlackAndCo.snowretailing.dal.entities.UserEntity;

import java.sql.Timestamp;

public interface IOrderModel extends IBaseModel {

    public Timestamp getDateOrderExpire();

    public void setDateOrderExpire(Timestamp dateOrderExpire);

    public Timestamp getDateOrder();

    public void setDateOrder(Timestamp dateOrder);

    public int getSumPay();

    public void setSumPay(int sumPay);
    IEquipmentItemModel getEquipmentItem();

    void setEquipmentItem(IEquipmentItemModel equipmentItem);

    String getUserName();

    void setUserName(String name);

     IEquipmentModel getEquipment();

     void setEquipment(IEquipmentModel equipment);

}
