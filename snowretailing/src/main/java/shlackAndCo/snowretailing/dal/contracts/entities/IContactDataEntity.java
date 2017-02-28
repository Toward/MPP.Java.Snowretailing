package shlackAndCo.snowretailing.dal.contracts.entities;

import shlackAndCo.snowretailing.dal.entities.CredentialEntity;

import javax.persistence.*;

public interface IContactDataEntity {

    public int getId();

    public void setId(int id);

    public String getPhoneNumber();

    public void setPhoneNumber(String phoneNumber);

    public CredentialEntity getCredentialByCredentialId();

    public void setCredentialByCredentialId(CredentialEntity credentialByCredentialId) ;
}
