package shlackAndCo.snowretailing.auth.models;

import org.hibernate.validator.constraints.NotEmpty;
import shlackAndCo.snowretailing.auth.contracts.models.ILoginModel;

import javax.validation.constraints.Size;

public class LoginModel implements ILoginModel {

    @NotEmpty
    @Size(min =3, max = 20)
    private String login;

    @NotEmpty
    @Size(min =3, max = 20)
    private String password;

    public LoginModel(){}

    public LoginModel(String login, String password){
        this.login = login;
        this.password = password;
    }

    @Override
    public String getLogin() {
        return login;
    }

    @Override
    public void setLogin(String login){
        this.login = login;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }
}
