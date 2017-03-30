package shlackAndCo.snowretailing.core.contracts.models;

import shlackAndCo.snowretailing.core.utils.CharacteristicsValue;
import shlackAndCo.snowretailing.dal.entities.*;

import java.util.Collection;

public interface IEquipmentModel extends IBaseModel, ITypeModel, IBrandModel {

    public String getModel();

    public void setModel(String model);

    public byte[] getPhoto();

    public void setPhoto(byte[] photo);

    public byte getDeleted();

    public void setDeleted(byte deleted);

    public int getQuantity();
    public Collection<CharacteristicsValue> getCharacteristicsValues();
}
