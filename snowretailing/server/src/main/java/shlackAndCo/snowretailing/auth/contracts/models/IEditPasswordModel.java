package shlackAndCo.snowretailing.auth.contracts.models;

public interface IEditPasswordModel {
    String getLogin();
    void setLogin(String login);

    String getOldPassword();
    void setOldPassword(String oldPassword);

    String getNewPassword();
    void setNewPassword(String newPassword);

    String getConfirmedNewPassword();
    void setConfirmedNewPassword(String confirmedNewPassword);
}
