package shlackAndCo.snowretailing.core.contracts.models;

public interface IUserWriteModel extends IBaseModel {
    String getLogin();
    void setLogin(String login);

    String getPassword();
    void setPassword(String password);

    int getRoleId();
    void setRoleId(int roleId);
}
