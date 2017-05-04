package shlackAndCo.snowretailing.core.models;


import org.hibernate.validator.constraints.NotEmpty;
import shlackAndCo.snowretailing.core.contracts.models.*;
import shlackAndCo.snowretailing.dal.contracts.entities.IOrderEntity;
import shlackAndCo.snowretailing.dal.entities.EquipmentItemEntity;

import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Timestamp;

public class OrderModel implements IOrderModel {
    private int id;
    //@DateTimeFormat(pattern="MM/dd/yyyy")
    @NotNull
    @Future
    private Timestamp dateOrderExpire;
    //@DateTimeFormat(pattern="MM/dd/yyyy")
    @NotNull
    private Timestamp dateOrder;
    @NotNull
    @Min(1)
    private int sumPay;
    @NotNull
    private IEquipmentItemModel equipmentItem;
    @NotNull
    private byte state;
    @NotEmpty
    @Size(min = 5, max = 30)
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
        state = orderEntity.getState();
    }
    @Override
    public byte getState() {
        return state;
    }
    @Override
    public void setState(byte state) {
        this.state = state;
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
        this.userName = name;
    }


}
