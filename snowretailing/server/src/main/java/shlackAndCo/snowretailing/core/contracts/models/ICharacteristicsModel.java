package shlackAndCo.snowretailing.core.contracts.models;

import shlackAndCo.snowretailing.dal.enums.CharacteristicsMeasurments;
import shlackAndCo.snowretailing.dal.enums.CharacteristicsNames;

public interface ICharacteristicsModel extends IBaseModel {

        CharacteristicsNames getName();

        void setName(CharacteristicsNames name);

        CharacteristicsMeasurments getMeasurment();

        void setMeasurment(CharacteristicsMeasurments measurment);
}
