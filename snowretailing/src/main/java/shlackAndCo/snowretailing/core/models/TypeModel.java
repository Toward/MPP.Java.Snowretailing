package shlackAndCo.snowretailing.core.models;

import shlackAndCo.snowretailing.core.contracts.models.ITypeModel;
import shlackAndCo.snowretailing.dal.contracts.entities.ITypeEntity;
import shlackAndCo.snowretailing.dal.enums.EquipmentTypes;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class TypeModel implements ITypeModel {
    private int id;

    @NotNull
    private EquipmentTypes name;

    @NotNull @Min(1)@Max(Integer.MAX_VALUE)
    private int cost;

    public TypeModel(){
        id = 0;
    }

    public TypeModel(ITypeEntity typeEntity){
        id = typeEntity.getId();
        name = typeEntity.getName();
        cost = typeEntity.getCost();
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
    public EquipmentTypes getName() {
        return name;
    }

    @Override
    public void setName(EquipmentTypes name) {
        this.name = name;
    }

    @Override
    public int getCost() {
        return cost;
    }

    @Override
    public void setCost(int cost) {
        this.cost = cost;
    }
}
