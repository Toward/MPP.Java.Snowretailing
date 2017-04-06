package shlackAndCo.snowretailing.core.models;


import shlackAndCo.snowretailing.core.contracts.models.*;
import shlackAndCo.snowretailing.dal.contracts.entities.IRentEntity;
import shlackAndCo.snowretailing.dal.entities.EquipmentItemEntity;

import java.sql.Timestamp;

public class RentModel implements IRentModel{
    private int id;
    private Timestamp dateExpectedReturn;
    private Timestamp dateFactReturn;
    private Timestamp dateGet;
    private IEquipmentItemModel equipmentItem;
    private ICredentialModel passport;
    private IEquipmentModel equipment;

    public RentModel(){
        id =0;
    }
    public RentModel(IRentEntity rentEntity){
        id = rentEntity.getId();
        dateExpectedReturn = rentEntity.getDateExpectedReturn();
        dateFactReturn = rentEntity.getDateFactReturn();
        dateGet = rentEntity.getDateGet();
        EquipmentItemEntity equipmentItemEntity = rentEntity.getEquipmentItemByEquipmentItemId();
        equipmentItem = new EquipmentItemModel(equipmentItemEntity);
        equipment = new EquipmentModel(equipmentItemEntity.getEquipmentByEquipmentId());
        passport = new CredentialModel(rentEntity.getCredentialByCredentialId());
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
    public IEquipmentModel getEquipment() {
        return equipment;
    }

    @Override
    public void setEquipment(IEquipmentModel equipment) {
        this.equipment = equipment;
    }

    @Override
    public void setPassport(ICredentialModel credentialModel) {
        this.passport = credentialModel;
    }

    @Override
    public ICredentialModel getPassport() {
        return passport;
    }
}
