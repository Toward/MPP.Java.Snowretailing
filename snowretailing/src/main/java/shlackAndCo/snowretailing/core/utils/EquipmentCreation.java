package shlackAndCo.snowretailing.core.utils;

import shlackAndCo.snowretailing.core.contracts.models.IBrandModel;
import shlackAndCo.snowretailing.core.contracts.models.ICharacteristicsModel;
import shlackAndCo.snowretailing.core.contracts.models.IEquipmentModel;
import shlackAndCo.snowretailing.core.contracts.models.ITypeModel;
import shlackAndCo.snowretailing.dal.enums.EquipmentTypes;

import java.util.Collection;

public class EquipmentCreation {
    private Collection<ITypeModel> availableTypes;
    private Collection<IBrandModel> availableBrands;
    private IEquipmentModel equipmentModel;
    private Collection<ICharacteristicsModel> availableCharacteristics;

    public void setEquipmentModel(IEquipmentModel equipmentModel){
        this.equipmentModel = equipmentModel;
    }

    public IEquipmentModel getEquipmentModel(){
        return equipmentModel;
    }
    public void setAvailableCharacteristics(Collection<ICharacteristicsModel> availableCharacteristics){
        this.availableCharacteristics = availableCharacteristics;
    }

    public Collection<ICharacteristicsModel> getCharacteristicsModel(){
        return availableCharacteristics;
    }

    public void setAvailableTypes(Collection<ITypeModel> availableTypes){
        this.availableTypes = availableTypes;
    }

    public Collection<ITypeModel> getAvailableTypes(){
        return availableTypes;
    }

    public void setAvailableBrands(Collection<IBrandModel> availableBrands){
        this.availableBrands = availableBrands;
    }

    public Collection<IBrandModel> getAvailableBrands(){
        return availableBrands;
    }
}
