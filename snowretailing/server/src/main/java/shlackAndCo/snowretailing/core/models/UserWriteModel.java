package shlackAndCo.snowretailing.core.models;

import org.hibernate.validator.constraints.NotEmpty;
import shlackAndCo.snowretailing.core.contracts.models.IUserWriteModel;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

public class UserWriteModel implements IUserWriteModel {
    private int id;
    @NotEmpty
    @Size(min =3, max = 20)
    private String login;
    @NotEmpty
    @Size(min =3, max = 20)
    private String password;
    @Min(1)
    @Max(3)
    private int roleId;

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
    public String getPassword() {
        return password;
    }

    @Override
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
