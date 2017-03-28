package shlackAndCo.snowretailing.auth.models;

import org.hibernate.validator.constraints.NotEmpty;
import shlackAndCo.snowretailing.auth.contracts.models.IRegisterModel;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Size;

public class RegisterModel implements IRegisterModel {
    @NotEmpty
    @Size(min =3, max = 20)
    private String login;
    @NotEmpty
    @Size(min =3, max = 20)
    private String password;
    @NotEmpty
    @Size(min =3, max = 20)
    private String confirmedPassword;

    @AssertTrue(message="confirmed password should be equal than password")
    private boolean isValid(){
        return this.password.equals(confirmedPassword);
    }

    public RegisterModel(){}

    public RegisterModel(String login, String password, String confirmedPassword){
        this.login = login;
        this.password = password;
        this.confirmedPassword = confirmedPassword;
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
    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getConfirmedPassword() {
        return confirmedPassword;
    }

    @Override
    public void setConfirmedPassword(String confirmedPassword) {
        this.confirmedPassword = confirmedPassword;
    }
}
