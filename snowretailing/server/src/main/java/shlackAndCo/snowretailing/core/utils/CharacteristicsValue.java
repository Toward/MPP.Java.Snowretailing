package shlackAndCo.snowretailing.core.utils;

import shlackAndCo.snowretailing.dal.enums.CharacteristicsMeasurments;
import shlackAndCo.snowretailing.dal.enums.CharacteristicsNames;
import shlackAndCo.snowretailing.dal.enums.EquipmentTypes;

public class CharacteristicsValue {
    private CharacteristicsNames name;
    private String value;
    private CharacteristicsMeasurments measurments;

    public CharacteristicsValue(){

    }
    public void setName(CharacteristicsNames name){
        this.name = name;
    }
    public CharacteristicsNames getName(){
        return name;
    }
    public void setValue(String value){
        this.value = value;
    }
    public String getValue(){
        return value;
    }
    public void setMeasurments(CharacteristicsMeasurments measurments){
        this.measurments = measurments;
    }
    public CharacteristicsMeasurments getMeasurments(){
        return measurments;
    }
}
