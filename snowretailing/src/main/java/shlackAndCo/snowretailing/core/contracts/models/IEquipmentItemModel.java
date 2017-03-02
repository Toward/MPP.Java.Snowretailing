package shlackAndCo.snowretailing.core.contracts.models;

import shlackAndCo.snowretailing.dal.entities.EquipmentEntity;
import shlackAndCo.snowretailing.dal.entities.OrderEntity;
import shlackAndCo.snowretailing.dal.entities.RentEntity;

import java.util.Collection;

public interface IEquipmentItemModel extends IBaseModel {

    public byte getDeleted();

    public void setDeleted(byte deleted);

}
