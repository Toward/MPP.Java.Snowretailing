package shlackAndCo.snowretailing.core.utils;

import shlackAndCo.snowretailing.core.contracts.models.ICredentialModel;
import shlackAndCo.snowretailing.core.contracts.models.IEquipmentModel;
import shlackAndCo.snowretailing.core.contracts.models.IRentReadModel;

import java.util.Collection;

public class RentCreation {
    private IRentReadModel rentModel;
    private Collection<IEquipmentModel> availableEquipments;
    private Collection<ICredentialModel> availablePassports;
    public void setRentModel(IRentReadModel rentModel){
        this.rentModel = rentModel;
    }

    public IRentReadModel getRentModel(){
        return rentModel;
    }

    public void setAvailableEquipments(Collection<IEquipmentModel> availableEquipments){
        this.availableEquipments = availableEquipments;
    }

    public Collection<IEquipmentModel> getAvailableEquipments(){
        return availableEquipments;
    }

    public void setAvailablePassports(Collection<ICredentialModel> availablePassports){
        this.availablePassports = availablePassports;
    }

    public Collection<ICredentialModel> getAvailablePassports(){
        return availablePassports;
    }
}
