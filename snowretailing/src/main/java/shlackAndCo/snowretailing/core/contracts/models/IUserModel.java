package shlackAndCo.snowretailing.core.contracts.models;

import shlackAndCo.snowretailing.dal.entities.CredentialEntity;
import shlackAndCo.snowretailing.dal.entities.OrderEntity;
import shlackAndCo.snowretailing.dal.entities.ReviewEntity;
import shlackAndCo.snowretailing.dal.entities.RoleEntity;

import java.util.Collection;

public interface IUserModel extends IBaseModel{

    String getLogin();

    void setLogin(String login);

    String getPasswordHash();

    void setPasswordHash(String passwordHash);

    IRoleModel getRole();

    void setRole(IRoleModel role);
}
