package shlackAndCo.snowretailing.auth.models;

import shlackAndCo.snowretailing.auth.contracts.models.IAuthModel;
import shlackAndCo.snowretailing.dal.contracts.entities.IUserEntity;

public class AuthModel implements IAuthModel {
    private int id;
    private String login;
    private String password;
    private int roleId;

    public AuthModel(IUserEntity user){
        this.id = user.getId();
        this.login = user.getLogin();
        this.password = user.getPasswordHash();
        this.roleId = user.getRoleByRoleId().getId();
    }

    public AuthModel(String login, String password){
        this.login = login;
        this.password = password;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
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

    @Override
    public int getRoleId() {
        return roleId;
    }

    @Override
    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }
}
