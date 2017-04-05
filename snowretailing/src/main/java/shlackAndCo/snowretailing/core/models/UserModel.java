package shlackAndCo.snowretailing.core.models;

import shlackAndCo.snowretailing.core.contracts.models.IUserModel;
import shlackAndCo.snowretailing.dal.contracts.entities.IUserEntity;

public class UserModel implements IUserModel {
    private int id;
    private String login;
    private String passwordHash;
    private int roleId;

    public UserModel(IUserEntity user){
        this.id = user.getId();
        this.login = user.getLogin();
        this.passwordHash = user.getPasswordHash();
        this.roleId = user.getRoleByRoleId().getId();
    }

    public UserModel(String login, String password){
        this.login = login;
        this.passwordHash = password;
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

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
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
