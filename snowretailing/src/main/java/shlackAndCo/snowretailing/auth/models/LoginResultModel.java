package shlackAndCo.snowretailing.auth.models;

import shlackAndCo.snowretailing.auth.contracts.models.ILoginResultModel;
import shlackAndCo.snowretailing.core.contracts.models.IRoleModel;

public class LoginResultModel implements ILoginResultModel {
    private int id;
    private String login;
    private IRoleModel role;
    private String token;

    public LoginResultModel(int id, String login, IRoleModel role, String token){
        this.id = id;
        this.login = login;
        this.role = role;
        this.token = token;
    }

    @Override
    public int getUserId() {
        return id;
    }

    @Override
    public void setUserId(int id) {
        this.id = id;
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
    public IRoleModel getRole() {
        return role;
    }

    @Override
    public void setRole(IRoleModel role) {
        this.role = role;
    }

    @Override
    public String getToken() {
        return token;
    }

    @Override
    public void setToken(String token) {
        this.token = token;
    }
}
