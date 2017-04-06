package shlackAndCo.snowretailing.core.contracts.services;


import shlackAndCo.snowretailing.core.contracts.models.IRentModel;
import shlackAndCo.snowretailing.dal.contracts.entities.IRentEntity;

public interface IRentService extends IBaseService<IRentModel, IRentEntity> {

    void setDateFactReturn(IRentModel model);

    void setPassport(IRentModel model);

}
