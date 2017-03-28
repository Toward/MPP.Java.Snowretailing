package shlackAndCo.snowretailing.dal.contracts.entities;

import shlackAndCo.snowretailing.dal.entities.RoleEntity;

import java.util.Collection;

public interface IPermissionsEntity {

    public int getId();
    public void setId(int id);

    public String getDescription();

    public void setDescription(String description);

    public Collection<RoleEntity> getRoles();

    public void setRoles(Collection<RoleEntity> roles);
}
