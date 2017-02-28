package shlackAndCo.snowretailing.core.models;

import org.hibernate.validator.constraints.NotEmpty;
import shlackAndCo.snowretailing.core.contracts.models.ITypeModel;
import shlackAndCo.snowretailing.dal.contracts.entities.ITypeEntity;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Владелец on 28/02/2017.
 */
public class TypeModel implements ITypeModel {
    private int id;

    @NotNull
    private Enum name;

    @NotNull @Min(0)
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
    public Enum getName() {
        return name;
    }

    @Override
    public void setName(Enum name) {
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
