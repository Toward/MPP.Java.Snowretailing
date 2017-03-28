package shlackAndCo.snowretailing.auth.contracts.models;

public interface IRegisterModel {
    String getLogin();
    void setLogin(String login);

    String getPassword();
    void setPassword(String password);

    String getConfirmedPassword();
    void setConfirmedPassword(String confirmedPassword);
}
