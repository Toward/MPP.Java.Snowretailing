package shlackAndCo.snowretailing.dal.contracts.entities;

import shlackAndCo.snowretailing.dal.entities.PermissionsEntity;
import shlackAndCo.snowretailing.dal.entities.RoleEntity;

import javax.persistence.*;

public interface IPToREntity {
    public int getRoleId();

    public void setRoleId(int roleId);

    public int getPermissionId();

    public void setPermissionId(int permissionId);

    public RoleEntity getRoleByRoleId();

    public void setRoleByRoleId(RoleEntity roleByRoleId);

    public PermissionsEntity getPermissionsByPermissionId();

    public void setPermissionsByPermissionId(PermissionsEntity permissionsByPermissionId);
}
