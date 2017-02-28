package shlackAndCo.snowretailing.dal.contracts.entities;

import shlackAndCo.snowretailing.dal.entities.EquipmentItemEntity;
import shlackAndCo.snowretailing.dal.entities.UserEntity;

import javax.persistence.*;
import java.sql.Timestamp;

public interface IOrderEntity {

    public int getId();

    public void setId(int id);

    public Timestamp getDateOrderExpire();

    public void setDateOrderExpire(Timestamp dateOrderExpire);

    public Timestamp getDateOrder();

    public void setDateOrder(Timestamp dateOrder);

    public int getSumPay();

    public void setSumPay(int sumPay);

    public UserEntity getUserByUserId();

    public void setUserByUserId(UserEntity userByUserId);

    public EquipmentItemEntity getEquipmentItemByItemId();

    public void setEquipmentItemByItemId(EquipmentItemEntity equipmentItemByItemId);
}
