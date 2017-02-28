package shlackAndCo.snowretailing.dal.entities;

import shlackAndCo.snowretailing.dal.contracts.entities.IRoleEntity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "role", schema = "snowretailing_db")
public class RoleEntity implements IRoleEntity {
    private int id;
    private String roleName;
    private Collection<PToREntity> pToRSById;
    private Collection<UserEntity> usersById;

    @Id
    @Column(name = "ID", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "ROLE_NAME", nullable = false, length = 50)
    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RoleEntity that = (RoleEntity) o;

        if (id != that.id) return false;
        if (roleName != null ? !roleName.equals(that.roleName) : that.roleName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (roleName != null ? roleName.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "roleByRoleId")
    public Collection<PToREntity> getpToRSById() {
        return pToRSById;
    }

    public void setpToRSById(Collection<PToREntity> pToRSById) {
        this.pToRSById = pToRSById;
    }

    @OneToMany(mappedBy = "roleByRoleId")
    public Collection<UserEntity> getUsersById() {
        return usersById;
    }

    public void setUsersById(Collection<UserEntity> usersById) {
        this.usersById = usersById;
    }
}
