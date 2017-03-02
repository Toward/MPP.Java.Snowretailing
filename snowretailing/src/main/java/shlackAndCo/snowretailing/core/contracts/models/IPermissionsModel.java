package shlackAndCo.snowretailing.core.contracts.models;

import shlackAndCo.snowretailing.dal.entities.PToREntity;

import java.util.Collection;

public interface IPermissionsModel extends IBaseModel {
    public String getDescription();

    public void setDescription(String description);
}
