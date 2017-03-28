package shlackAndCo.snowretailing.auth.contracts.models;

public interface ILoginModel {
    String getLogin();
    void setLogin(String login);

    String getPassword();
    void setPassword(String password);
}
