package shlackAndCo.snowretailing.core.contracts.models;

import shlackAndCo.snowretailing.dal.entities.EquipmentEntity;
import shlackAndCo.snowretailing.dal.entities.OrderEntity;
import shlackAndCo.snowretailing.dal.entities.RentEntity;

import java.util.Collection;

public interface IEquipmentItemModel extends IBaseModel {

    byte getDeleted();

    void setDeleted(byte deleted);

    void setEquipmentModel(IEquipmentModel equipmentModel);

    IEquipmentModel getEquipmentModel();
}
