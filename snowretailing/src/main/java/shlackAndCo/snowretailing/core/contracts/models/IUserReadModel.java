package shlackAndCo.snowretailing.core.contracts.models;

public interface IUserReadModel extends IBaseModel {
    String getLogin();
    void setLogin(String login);

    IRoleModel getRole();
    void setRole(IRoleModel role);
}
