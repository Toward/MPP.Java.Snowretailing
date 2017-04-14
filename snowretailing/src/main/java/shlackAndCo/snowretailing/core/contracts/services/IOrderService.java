package shlackAndCo.snowretailing.core.contracts.services;

import shlackAndCo.snowretailing.core.contracts.models.IOrderModel;
import shlackAndCo.snowretailing.dal.contracts.entities.IOrderEntity;

import java.util.Collection;

public interface IOrderService extends IBaseService<IOrderModel>{
    Collection<IOrderModel> getUsersOrders(String userName);
}
