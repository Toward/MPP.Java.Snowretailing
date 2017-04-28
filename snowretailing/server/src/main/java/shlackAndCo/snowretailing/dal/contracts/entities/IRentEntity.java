package shlackAndCo.snowretailing.dal.contracts.entities;

import shlackAndCo.snowretailing.dal.entities.CredentialEntity;
import shlackAndCo.snowretailing.dal.entities.EquipmentItemEntity;

import javax.persistence.*;
import java.sql.Timestamp;

public interface IRentEntity {
    public Timestamp getDateExpectedReturn();

    public void setDateExpectedReturn(Timestamp dateExpectedReturn);

    public Timestamp getDateFactReturn();

    public void setDateFactReturn(Timestamp dateFactReturn);

    public Timestamp getDateGet();

    public void setDateGet(Timestamp dateGet);

    public int getId();

    public void setId(int id);

    public CredentialEntity getCredentialByCredentialId();

    public void setCredentialByCredentialId(CredentialEntity credentialByCredentialId) ;

    public EquipmentItemEntity getEquipmentItemByEquipmentItemId();

    public void setEquipmentItemByEquipmentItemId(EquipmentItemEntity equipmentItemByEquipmentItemId);
}
