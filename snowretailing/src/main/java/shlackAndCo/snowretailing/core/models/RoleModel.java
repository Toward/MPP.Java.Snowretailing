package shlackAndCo.snowretailing.core.models;

import shlackAndCo.snowretailing.core.contracts.models.IRoleModel;
import shlackAndCo.snowretailing.core.enums.Role;
import shlackAndCo.snowretailing.dal.contracts.entities.IRoleEntity;

public class RoleModel implements IRoleModel {
    private int id;
    private String roleName;

    public RoleModel(IRoleEntity role){
        this.id = role.getId();
        this.roleName = role.getRoleName();
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getRoleName() {
        return roleName;
    }

    @Override
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
