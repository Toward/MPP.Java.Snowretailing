package shlackAndCo.snowretailing.core.utils;

import shlackAndCo.snowretailing.core.contracts.models.IEquipmentItemModel;
import shlackAndCo.snowretailing.core.contracts.models.IEquipmentModel;

import java.util.Collection;

public class EquipmentItemCreation {
    private Collection<IEquipmentModel> availableEquipments;
    private IEquipmentItemModel equipmentItemModel;

    public void setEquipmentItemModel(IEquipmentItemModel equipmentItemModel){
        this.equipmentItemModel = equipmentItemModel;
    }

    public IEquipmentItemModel getEquipmentItemModel(){
        return equipmentItemModel;
    }

    public void setAvailableEquipments(Collection<IEquipmentModel> availableCharacteristics){
        this.availableEquipments = availableCharacteristics;
    }

    public Collection<IEquipmentModel> getAvailableEquipments(){
        return availableEquipments;
    }
}

