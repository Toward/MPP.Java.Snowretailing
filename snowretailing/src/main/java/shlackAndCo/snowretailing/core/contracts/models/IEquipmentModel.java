package shlackAndCo.snowretailing.core.contracts.models;

import shlackAndCo.snowretailing.dal.entities.*;

import java.util.Collection;

public interface IEquipmentModel extends IBaseModel {

    public String getModel();

    public void setModel(String model);

    public byte[] getPhoto();

    public void setPhoto(byte[] photo);

    public byte getDeleted();

    public void setDeleted(byte deleted);
}
