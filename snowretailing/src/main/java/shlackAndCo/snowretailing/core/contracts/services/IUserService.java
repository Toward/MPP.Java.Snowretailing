package shlackAndCo.snowretailing.core.contracts.services;

import shlackAndCo.snowretailing.core.contracts.models.IUserReadModel;
import shlackAndCo.snowretailing.core.contracts.models.IUserWriteModel;

import java.util.Collection;

public interface IUserService {
    Collection<IUserReadModel> getUsers();
    IUserReadModel getById(int userId);
    IUserReadModel getByLogin(String login);
    int create(IUserWriteModel model);
    void edit(IUserWriteModel model);
    void delete(int userId);
}
