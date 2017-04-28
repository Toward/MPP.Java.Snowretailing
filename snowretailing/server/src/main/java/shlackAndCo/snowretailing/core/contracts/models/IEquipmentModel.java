package shlackAndCo.snowretailing.core.contracts.models;

import shlackAndCo.snowretailing.core.utils.CharacteristicsValue;
import shlackAndCo.snowretailing.dal.entities.*;

import java.util.Collection;

public interface IEquipmentModel extends IBaseModel, ITypeModel, IBrandModel {

     String getModel();

     void setModel(String model);

     byte[] getPhoto();

     void setPhoto(byte[] photo);

     byte getDeleted();

     void setDeleted(byte deleted);

     int getQuantity();

     Collection<CharacteristicsValue> getCharacteristicsValues();

     void setCharacteristicsValues(Collection<CharacteristicsValue> characteristicsValues);
}
