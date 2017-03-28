package shlackAndCo.snowretailing.core.models;

import shlackAndCo.snowretailing.core.contracts.models.IUserModel;

public class UserModel implements IUserModel {
    private String login;
    private String password;

    public UserModel(){}

    public UserModel(String login, String password){
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
