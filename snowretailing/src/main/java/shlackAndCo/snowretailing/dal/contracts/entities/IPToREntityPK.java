package shlackAndCo.snowretailing.dal.contracts.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public interface IPToREntityPK extends Serializable {
    public int getRoleId();

    public void setRoleId(int roleId);

    public int getPermissionId();

    public void setPermissionId(int permissionId);
}
