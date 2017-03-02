package shlackAndCo.snowretailing.core.contracts.models;

/**
 * Created by Владелец on 02/03/2017.
 */
public interface ICharacteristicsModel extends IBaseModel {

        public Enum getName();

        public void setName(Enum name);

        public Enum getMeasurment();

        public void setMeasurment(Enum measurment);


}
