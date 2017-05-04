package shlackAndCo.snowretailing.core.models;


import shlackAndCo.snowretailing.core.contracts.models.ICredentialModel;
import shlackAndCo.snowretailing.core.contracts.models.IEquipmentItemModel;
import shlackAndCo.snowretailing.core.contracts.models.IRentReadModel;
import shlackAndCo.snowretailing.dal.contracts.entities.IRentEntity;

import java.sql.Timestamp;

public class RentReadModel implements IRentReadModel {
    private int id;
    private Timestamp dateExpectedReturn;
    private Timestamp dateFactReturn;
    private Timestamp dateGet;
    private IEquipmentItemModel equipmentItem;
    private ICredentialModel credential;

    public RentReadModel(){
        id =0;
    }

    public RentReadModel(IRentEntity rentEntity){
        id = rentEntity.getId();
        dateExpectedReturn = rentEntity.getDateExpectedReturn();
        dateFactReturn = rentEntity.getDateFactReturn();
        dateGet = rentEntity.getDateGet();
        equipmentItem = new EquipmentItemModel(rentEntity.getEquipmentItemByEquipmentItemId());
        credential = new CredentialModel(rentEntity.getCredentialByCredentialId());
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public Timestamp getDateExpectedReturn() {
        return dateExpectedReturn;
    }

    @Override
    public void setDateExpectedReturn(Timestamp dateExpectedReturn) {
        this.dateExpectedReturn = dateExpectedReturn;
    }

    @Override
    public Timestamp getDateFactReturn() {
        return dateFactReturn;
    }

    @Override
    public void setDateFactReturn(Timestamp dateFactReturn) {
        this.dateFactReturn = dateFactReturn;
    }

    @Override
    public Timestamp getDateGet() {
        return dateGet;
    }

    @Override
    public void setDateGet(Timestamp dateGet) {
        this.dateGet = dateGet;
    }

    @Override
    public IEquipmentItemModel getEquipmentItem() {
        return equipmentItem;
    }

    @Override
    public void setEquipmentItem(IEquipmentItemModel equipmentItem) {
        this.equipmentItem = equipmentItem;
    }

    @Override
    public void setCredential(ICredentialModel credentialModel) {
        this.credential = credentialModel;
    }

    @Override
    public ICredentialModel getCredential() {
        return credential;
    }
}
