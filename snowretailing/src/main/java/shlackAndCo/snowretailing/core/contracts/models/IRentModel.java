package shlackAndCo.snowretailing.core.contracts.models;

import shlackAndCo.snowretailing.dal.entities.CredentialEntity;
import shlackAndCo.snowretailing.dal.entities.EquipmentItemEntity;

import java.sql.Timestamp;

public interface IRentModel extends IBaseModel {
    public Timestamp getDateExpectedReturn();

    public void setDateExpectedReturn(Timestamp dateExpectedReturn);

    public Timestamp getDateFactReturn();

    public void setDateFactReturn(Timestamp dateFactReturn);

    public Timestamp getDateGet();

    public void setDateGet(Timestamp dateGet);
}
