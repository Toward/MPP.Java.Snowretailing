package shlackAndCo.snowretailing.core.models;

import org.hibernate.validator.constraints.NotEmpty;
import shlackAndCo.snowretailing.core.contracts.models.IRentWriteModel;

import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

public class RentWriteModel implements IRentWriteModel {
    private int id;
    //@DateTimeFormat(pattern="MM/dd/yyyy")
    @NotNull
    @Future
    private Timestamp dateExpectedReturn;
    //@DateTimeFormat(pattern="MM/dd/yyyy")
    //@NotNull
    @Future
    private Timestamp dateFactReturn;
    //@DateTimeFormat(pattern="MM/dd/yyyy")
    @NotNull
    private Timestamp dateGet;
    @NotNull
    @Min(1)
    private int equipmentItemId;
    @NotNull
    @Min(1)
    private int credentialId;

    public RentWriteModel(){
        id =0;
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
    public int getEquipmentItemId() {
        return equipmentItemId;
    }

    @Override
    public void setEquipmentItemId(int equipmentItemId) {
        this.equipmentItemId = equipmentItemId;
    }

    @Override
    public void setCredentialId(int credentialId) {
        this.credentialId = credentialId;
    }

    @Override
    public int getCredentialId() {
        return credentialId;
    }
}
