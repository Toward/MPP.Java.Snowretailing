package shlackAndCo.snowretailing.core.contracts.services;


import shlackAndCo.snowretailing.core.contracts.models.IRentReadModel;
import shlackAndCo.snowretailing.core.contracts.models.IRentWriteModel;

import java.util.Collection;

public interface IRentService {
    Collection<IRentReadModel> getAll();

    IRentReadModel getById(int id);

    int create(IRentWriteModel model);

    void edit(IRentWriteModel model);

    void delete(int id);
}
