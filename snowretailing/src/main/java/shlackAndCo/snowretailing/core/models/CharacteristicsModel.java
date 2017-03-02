package shlackAndCo.snowretailing.core.models;

import shlackAndCo.snowretailing.core.contracts.models.ICharacteristicsModel;
import shlackAndCo.snowretailing.dal.contracts.entities.ICharacteristicsEntity;

import javax.validation.constraints.NotNull;

/**
 * Created by Владелец on 02/03/2017.
 */
public class CharacteristicsModel implements ICharacteristicsModel {

    private int id;
    @NotNull
    private Enum name;
    @NotNull
    private Enum measurment;

    public CharacteristicsModel(){
        id = 0;
    }
    public CharacteristicsModel (ICharacteristicsEntity entity){
        id = entity.getId();
        name = entity.getName();
        measurment = entity.getMeasurment();
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
    public Enum getName() {
        return name;
    }

    @Override
    public void setName(Enum name) {
        this.name = name;
    }

    @Override
    public Enum getMeasurment() {
        return measurment;
    }

    @Override
    public void setMeasurment(Enum measurment) {
        this.measurment = measurment;
    }
}
