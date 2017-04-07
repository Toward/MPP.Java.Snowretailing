package shlackAndCo.snowretailing.core.models;

import shlackAndCo.snowretailing.core.contracts.models.IRoleModel;
import shlackAndCo.snowretailing.core.contracts.models.IUserReadModel;

public class UserReadModel implements IUserReadModel {
    private int id;
    private String login;
    private IRoleModel role;

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
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
}
