package shlackAndCo.snowretailing.core.models;

import shlackAndCo.snowretailing.core.contracts.models.ICharacteristicsModel;
import shlackAndCo.snowretailing.dal.contracts.entities.ICharacteristicsEntity;
import shlackAndCo.snowretailing.dal.enums.CharacteristicsMeasurments;
import shlackAndCo.snowretailing.dal.enums.CharacteristicsNames;

import javax.validation.constraints.NotNull;

/**
 * Created by Владелец on 02/03/2017.
 */
public class CharacteristicsModel implements ICharacteristicsModel {

    private int id;
    @NotNull
    private CharacteristicsNames name;
    @NotNull
    private CharacteristicsMeasurments measurment;

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
    public CharacteristicsNames getName() {
        return name;
    }

    @Override
    public void setName(CharacteristicsNames name) {
        this.name = name;
    }

    @Override
    public CharacteristicsMeasurments getMeasurment() {
        return measurment;
    }

    @Override
    public void setMeasurment(CharacteristicsMeasurments measurment) {
        this.measurment = measurment;
    }
}
