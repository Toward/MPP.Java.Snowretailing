package shlackAndCo.snowretailing.dal.contracts.entities;

import shlackAndCo.snowretailing.dal.entities.PermissionsEntity;
import shlackAndCo.snowretailing.dal.entities.UserEntity;

import java.util.Collection;

public interface IRoleEntity {

    public int getId();

    public void setId(int id);

    public String getRoleName();

    public void setRoleName(String roleName);

    public Collection<PermissionsEntity> getPermissions();

    public void setPermissions(Collection<PermissionsEntity> permissions);

    public Collection<UserEntity> getUsersById();

    public void setUsersById(Collection<UserEntity> usersById);
}
