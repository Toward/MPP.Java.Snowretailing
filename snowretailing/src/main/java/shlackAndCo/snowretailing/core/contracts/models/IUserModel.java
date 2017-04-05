package shlackAndCo.snowretailing.core.contracts.models;

public interface IUserModel extends IBaseModel{
    String getLogin();
    void setLogin(String login);

    String getPasswordHash();
    void setPasswordHash(String passwordHash);

    int getRoleId();
    void setRoleId(int roleId);
}
