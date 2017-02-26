package shlackAndCo.snowretailing.dal.entities;

import javax.persistence.*;

@Entity
@Table(name = "p_to_r", schema = "snowretailing_db")
@IdClass(PToREntityPK.class)
public class PToREntity {
    private int roleId;
    private int permissionId;
    private RoleEntity roleByRoleId;
    private PermissionsEntity permissionsByPermissionId;

    @Id
    @Column(name = "ROLE_ID", nullable = false)
    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    @Id
    @Column(name = "PERMISSION_ID", nullable = false)
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

        PToREntity that = (PToREntity) o;

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

    @ManyToOne
    @JoinColumn(name = "ROLE_ID", referencedColumnName = "ID", nullable = false)
    public RoleEntity getRoleByRoleId() {
        return roleByRoleId;
    }

    public void setRoleByRoleId(RoleEntity roleByRoleId) {
        this.roleByRoleId = roleByRoleId;
    }

    @ManyToOne
    @JoinColumn(name = "PERMISSION_ID", referencedColumnName = "ID", nullable = false)
    public PermissionsEntity getPermissionsByPermissionId() {
        return permissionsByPermissionId;
    }

    public void setPermissionsByPermissionId(PermissionsEntity permissionsByPermissionId) {
        this.permissionsByPermissionId = permissionsByPermissionId;
    }
}
