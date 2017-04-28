package shlackAndCo.snowretailing.auth.contracts.models;

import shlackAndCo.snowretailing.core.contracts.models.IRoleModel;

public interface ILoginResultModel {
    int getUserId();
    void setUserId(int id);

    String getLogin();
    void setLogin(String login);

    IRoleModel getRole();
    void setRole(IRoleModel role);

    String getToken();
    void setToken(String token);
}
