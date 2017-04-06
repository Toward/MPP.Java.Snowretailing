package shlackAndCo.snowretailing.core.models;


import shlackAndCo.snowretailing.core.contracts.models.*;
import shlackAndCo.snowretailing.dal.contracts.entities.IOrderEntity;
import shlackAndCo.snowretailing.dal.entities.EquipmentItemEntity;
import shlackAndCo.snowretailing.dal.entities.OrderEntity;

import java.sql.Timestamp;

public class OrderModel implements IOrderModel {
    private int id;
    private Timestamp dateOrderExpire;
    private Timestamp dateOrder;
    private int sumPay;
    private IEquipmentItemModel equipmentItem;
    private IEquipmentModel equipment;
    private String userName;

    public OrderModel(){
        id = 0;
    }

    public OrderModel(IOrderEntity orderEntity){
        id = orderEntity.getId();
        dateOrderExpire = orderEntity.getDateOrderExpire();
        dateOrder = orderEntity.getDateOrder();
        sumPay = orderEntity.getSumPay();
        EquipmentItemEntity equipmentItemEntity = orderEntity.getEquipmentItemByItemId();
        equipmentItem = new EquipmentItemModel(equipmentItemEntity);
        userName = orderEntity.getUserByUserId().getLogin();
        equipment = new EquipmentModel(equipmentItemEntity.getEquipmentByEquipmentId());
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public Timestamp getDateOrderExpire() {
        return dateOrderExpire;
    }

    @Override
    public void setDateOrderExpire(Timestamp dateOrderExpire) {
        this.dateOrderExpire = dateOrderExpire;
    }

    @Override
    public Timestamp getDateOrder() {
        return dateOrder;
    }

    @Override
    public void setDateOrder(Timestamp dateOrder) {
        this.dateOrder = dateOrder;
    }

    @Override
    public int getSumPay() {
        return sumPay;
    }

    @Override
    public void setSumPay(int sumPay) {
        this.sumPay = sumPay;
    }

    @Override
    public IEquipmentModel getEquipment() {
        return equipment;
    }

    @Override
    public void setEquipment(IEquipmentModel equipment) {
        this.equipment = equipment;
    }

    @Override
    public IEquipmentItemModel getEquipmentItem() {
        return equipmentItem;
    }

    @Override
    public void setEquipmentItem(IEquipmentItemModel equipmentItem) {
        this.equipmentItem = equipmentItem;
    }

    @Override
    public String getUserName() {
        return userName;
    }

    @Override
    public void setUserName(String name) {
        this.userName = userName;
    }


}
