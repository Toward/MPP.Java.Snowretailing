package shlackAndCo.snowretailing.core.utils;

import shlackAndCo.snowretailing.core.contracts.models.IEquipmentModel;
import shlackAndCo.snowretailing.core.contracts.models.IOrderModel;

import java.util.Collection;

public class OrderCreation {
    private IOrderModel orderModel;
    private Collection<IEquipmentModel> availableEquipments;
     public void setOrderModel(IOrderModel orderModel){
         this.orderModel = orderModel;
     }

     public IOrderModel getOrderModel(){
         return orderModel;
     }

     public void setAvailableEquipments(Collection<IEquipmentModel> availableEquipments){
         this.availableEquipments = availableEquipments;
     }

     public Collection<IEquipmentModel> getAvailableEquipments(){
         return availableEquipments;
     }
}
