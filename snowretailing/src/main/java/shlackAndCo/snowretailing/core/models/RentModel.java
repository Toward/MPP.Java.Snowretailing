package shlackAndCo.snowretailing.core.models;


import shlackAndCo.snowretailing.core.contracts.models.IOrderModel;
import shlackAndCo.snowretailing.core.contracts.models.IRentModel;

import java.sql.Timestamp;

public class RentModel implements IRentModel{
    private int id;
    private Timestamp dateExpectedReturn;
    private Timestamp dateFactReturn;
    private Timestamp dateGet;
    private IOrderModel orderModel;

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public Timestamp getDateExpectedReturn() {
        return dateExpectedReturn;
    }

    @Override
    public void setDateExpectedReturn(Timestamp dateExpectedReturn) {
        this.dateExpectedReturn = dateExpectedReturn;
    }

    @Override
    public Timestamp getDateFactReturn() {
        return dateFactReturn;
    }

    @Override
    public void setDateFactReturn(Timestamp dateFactReturn) {
        this.dateFactReturn = dateFactReturn;
    }

    @Override
    public Timestamp getDateGet() {
        return dateGet;
    }

    @Override
    public void setDateGet(Timestamp dateGet) {
        this.dateGet = dateGet;
    }

    @Override
    public IOrderModel getOrderModel() {
        return orderModel;
    }

    @Override
    public void setOrderModel(IOrderModel orderModel) {
        this.orderModel = orderModel;
    }
}
