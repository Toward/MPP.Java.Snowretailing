package shlackAndCo.snowretailing.core.contracts.models;

import shlackAndCo.snowretailing.dal.entities.CredentialEntity;
import shlackAndCo.snowretailing.dal.entities.EquipmentItemEntity;

import java.sql.Timestamp;

public interface IRentModel extends IBaseModel {
     Timestamp getDateExpectedReturn();

     void setDateExpectedReturn(Timestamp dateExpectedReturn);

     Timestamp getDateFactReturn();

     void setDateFactReturn(Timestamp dateFactReturn);

     Timestamp getDateGet();

     void setDateGet(Timestamp dateGet);

     IOrderModel getOrderModel();

     void setOrderModel(IOrderModel orderModel);

}
