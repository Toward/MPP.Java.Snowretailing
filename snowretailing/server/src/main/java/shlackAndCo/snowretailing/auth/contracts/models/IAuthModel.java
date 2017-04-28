package shlackAndCo.snowretailing.auth.contracts.models;

import shlackAndCo.snowretailing.core.contracts.models.IBaseModel;
import shlackAndCo.snowretailing.core.contracts.models.IRoleModel;

public interface IAuthModel extends IBaseModel {

    String getLogin();

    void setLogin(String login);

    String getPassword();

    void setPassword(String password);

    int getRoleId();

    void setRoleId(int roleId);
}
