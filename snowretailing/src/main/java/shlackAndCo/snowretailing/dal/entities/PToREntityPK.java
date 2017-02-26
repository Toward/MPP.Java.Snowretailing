package shlackAndCo.snowretailing.dal.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class PToREntityPK implements Serializable {
    private int roleId;
    private int permissionId;

    @Column(name = "ROLE_ID", nullable = false,updatable = false, insertable = false)
    @Id
    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    @Column(name = "PERMISSION_ID", nullable = false,updatable = false, insertable = false)
    @Id
    public int getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(int permissionId) {
        this.permissionId = permissionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PToREntityPK that = (PToREntityPK) o;

        if (roleId != that.roleId) return false;
        if (permissionId != that.permissionId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = roleId;
        result = 31 * result + permissionId;
        return result;
    }
}
