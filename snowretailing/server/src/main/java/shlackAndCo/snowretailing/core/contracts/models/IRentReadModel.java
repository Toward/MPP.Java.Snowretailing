package shlackAndCo.snowretailing.core.contracts.models;


import java.sql.Timestamp;

public interface IRentReadModel extends IBaseModel {
     Timestamp getDateExpectedReturn();
     void setDateExpectedReturn(Timestamp dateExpectedReturn);

     Timestamp getDateFactReturn();
     void setDateFactReturn(Timestamp dateFactReturn);

     Timestamp getDateGet();
     void setDateGet(Timestamp dateGet);

     IEquipmentItemModel getEquipmentItem();
     void setEquipmentItem(IEquipmentItemModel equipmentItem);

     ICredentialModel getCredential();
     void setCredential(ICredentialModel credentialModel);
}
