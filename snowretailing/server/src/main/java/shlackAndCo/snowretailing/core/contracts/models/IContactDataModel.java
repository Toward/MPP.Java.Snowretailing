package shlackAndCo.snowretailing.core.contracts.models;

import shlackAndCo.snowretailing.dal.entities.CredentialEntity;

public interface IContactDataModel extends IBaseModel {

    public String getPhoneNumber();

    public void setPhoneNumber(String phoneNumber);
}
