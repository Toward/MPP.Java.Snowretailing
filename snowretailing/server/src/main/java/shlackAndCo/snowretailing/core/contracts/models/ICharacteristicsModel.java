package shlackAndCo.snowretailing.core.contracts.models;

import shlackAndCo.snowretailing.dal.enums.CharacteristicsMeasurments;
import shlackAndCo.snowretailing.dal.enums.CharacteristicsNames;

/**
 * Created by Владелец on 02/03/2017.
 */
public interface ICharacteristicsModel extends IBaseModel {

        public CharacteristicsNames getName();

        public void setName(CharacteristicsNames name);

        public CharacteristicsMeasurments getMeasurment();

        public void setMeasurment(CharacteristicsMeasurments measurment);


}
