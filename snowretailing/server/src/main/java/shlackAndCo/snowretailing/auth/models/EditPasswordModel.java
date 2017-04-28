package shlackAndCo.snowretailing.auth.models;

import org.hibernate.validator.constraints.NotEmpty;
import shlackAndCo.snowretailing.auth.contracts.models.IEditPasswordModel;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Size;

public class EditPasswordModel implements IEditPasswordModel {
    @NotEmpty
    @Size(min =3, max = 20)
    private String login;
    @NotEmpty
    @Size(min =3, max = 20)
    private String oldPassword;
    @NotEmpty
    @Size(min =3, max = 20)
    private String newPassword;
    @NotEmpty
    @Size(min =3, max = 20)
    private String confirmedNewPassword;

    @AssertTrue(message="confirmed new password should be equal than new password")
    private boolean isValid(){
        return this.newPassword.equals(confirmedNewPassword);
    }

    public EditPasswordModel(){}

    public EditPasswordModel(String login, String oldPassword, String newPassword, String confirmedNewPassword){
        this.login = login;
        this.oldPassword = oldPassword;
        this.newPassword = newPassword;
        this.confirmedNewPassword = confirmedNewPassword;
    }

    @Override
    public String getLogin() {
        return login;
    }

    @Override
    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public String getOldPassword() {
        return oldPassword;
    }

    @Override
    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    @Override
    public String getNewPassword() {
        return newPassword;
    }

    @Override
    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    @Override
    public String getConfirmedNewPassword() {
        return confirmedNewPassword;
    }

    @Override
    public void setConfirmedNewPassword(String confirmedNewPassword) {
        this.confirmedNewPassword = confirmedNewPassword;
    }
}
