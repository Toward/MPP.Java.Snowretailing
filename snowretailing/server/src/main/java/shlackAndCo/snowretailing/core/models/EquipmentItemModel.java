package shlackAndCo.snowretailing.core.models;

import org.hibernate.validator.constraints.NotEmpty;
import shlackAndCo.snowretailing.core.contracts.models.IEquipmentItemModel;
import shlackAndCo.snowretailing.core.contracts.models.IEquipmentModel;
import shlackAndCo.snowretailing.dal.contracts.entities.IEquipmentItemEntity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class EquipmentItemModel implements IEquipmentItemModel {
    private int id;
    @NotNull
    private byte deleted;


    @NotNull
    private byte state;
    @NotEmpty
    @Size(min=2, max=20)
    private String inventory_number;


    public EquipmentItemModel(){
        id = 0;
    }

    public EquipmentItemModel(IEquipmentItemEntity equipmentEntity){
        id = equipmentEntity.getId();
        deleted = equipmentEntity.getDeleted();
        state = equipmentEntity.getState();
        inventory_number = equipmentEntity.getInventoryNumber();

    }
    @Override
    public byte getState() {
        return state;
    }
    @Override
    public void setState(byte state) {
        this.state = state;
    }
    @Override
    public String getInventory_number() {
        return inventory_number;
    }
    @Override
    public void setInventory_number(String inventory_number) {
        this.inventory_number = inventory_number;
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
    public byte getDeleted() {
        return deleted;
    }

    @Override
    public void setDeleted(byte deleted) {
        this.deleted = deleted;
    }

}
