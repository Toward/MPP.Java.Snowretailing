package shlackAndCo.snowretailing.core.contracts.models;

import shlackAndCo.snowretailing.dal.entities.CredentialEntity;
import shlackAndCo.snowretailing.dal.entities.OrderEntity;
import shlackAndCo.snowretailing.dal.entities.ReviewEntity;
import shlackAndCo.snowretailing.dal.entities.RoleEntity;

import java.util.Collection;

public interface IUserModel{

    public String getLogin();

    public void setLogin(String login);

    public String getPassword();

    public void setPassword(String passwordhash);
}
