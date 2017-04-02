package shlackAndCo.snowretailing.core.contracts.services;

import shlackAndCo.snowretailing.core.contracts.models.IUserModel;
import shlackAndCo.snowretailing.dal.contracts.entities.IUserEntity;

public interface IUserService extends IBaseService<IUserModel, IUserEntity> {
    IUserModel getByLogin(String login);
}
