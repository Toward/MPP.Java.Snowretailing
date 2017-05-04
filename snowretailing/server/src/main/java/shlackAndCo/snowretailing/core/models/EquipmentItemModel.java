package shlackAndCo.snowretailing.core.models;

import shlackAndCo.snowretailing.core.contracts.models.IEquipmentItemModel;
import shlackAndCo.snowretailing.core.contracts.models.IEquipmentModel;
import shlackAndCo.snowretailing.dal.contracts.entities.IEquipmentItemEntity;

import javax.validation.constraints.NotNull;

public class EquipmentItemModel implements IEquipmentItemModel {
    private int id;;
    @NotNull
    private IEquipmentModel equipmentModel;

    public EquipmentItemModel(){
        id = 0;
    }

    public EquipmentItemModel(IEquipmentItemEntity equipmentEntity){
        id = equipmentEntity.getId();
        equipmentModel = new EquipmentModel(equipmentEntity.getEquipmentByEquipmentId());
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
    public void setEquipmentModel(IEquipmentModel equipmentModel) {
        this.equipmentModel = equipmentModel;
    }

    @Override
    public IEquipmentModel getEquipmentModel() {
        return equipmentModel;
    }
}
