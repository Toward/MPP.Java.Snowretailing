package shlackAndCo.snowretailing.dal.contracts.entities;

import shlackAndCo.snowretailing.dal.entities.PToREntity;
import shlackAndCo.snowretailing.dal.entities.UserEntity;

import javax.persistence.*;
import java.util.Collection;

public interface IRoleEntity {

    public int getId();

    public void setId(int id);

    public String getRoleName();

    public void setRoleName(String roleName);

    public Collection<PToREntity> getpToRSById();

    public void setpToRSById(Collection<PToREntity> pToRSById);

    public Collection<UserEntity> getUsersById();

    public void setUsersById(Collection<UserEntity> usersById);
}
