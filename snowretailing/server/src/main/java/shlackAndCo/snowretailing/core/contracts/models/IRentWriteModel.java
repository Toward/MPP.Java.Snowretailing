package shlackAndCo.snowretailing.core.contracts.models;

import java.sql.Timestamp;

public interface IRentWriteModel extends IBaseModel {
    Timestamp getDateExpectedReturn();
    void setDateExpectedReturn(Timestamp dateExpectedReturn);

    Timestamp getDateFactReturn();
    void setDateFactReturn(Timestamp dateFactReturn);

    Timestamp getDateGet();
    void setDateGet(Timestamp dateGet);

    int getEquipmentItemId();
    void setEquipmentItemId(int equipmentItemId);

    int getCredentialId();
    void setCredentialId(int credentialId);
}
