package shlackAndCo.snowretailing.core.contracts.models;

import shlackAndCo.snowretailing.dal.entities.PToREntity;
import shlackAndCo.snowretailing.dal.entities.UserEntity;

import java.util.Collection;

public interface IRoleModel extends IBaseModel {

    public String getRoleName();

    public void setRoleName(String roleName);
}
