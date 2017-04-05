package shlackAndCo.snowretailing.core.models;


import shlackAndCo.snowretailing.core.contracts.models.IOrderModel;
import shlackAndCo.snowretailing.core.contracts.models.IRentModel;

import java.sql.Timestamp;

public class OrderModel implements IOrderModel {
    private int id;
    private Timestamp dateOrderExpire;
    private Timestamp dateOrder;
    private int sumPay;
    private IRentModel rentModel;


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
    public void setRentModel(IRentModel rentModel) {
        this.rentModel = rentModel;
    }

    @Override
    public IRentModel getRentModel() {
        return rentModel;
    }
}
