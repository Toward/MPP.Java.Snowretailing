package shlackAndCo.snowretailing.core.contracts.models;

import shlackAndCo.snowretailing.dal.entities.PermissionsEntity;
import shlackAndCo.snowretailing.dal.entities.RoleEntity;

public interface IPToRModel {
    public int getRoleId();

    public void setRoleId(int roleId);

    public int getPermissionId();

    public void setPermissionId(int permissionId);
}
