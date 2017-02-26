package shlackAndCo.snowretailing.core.contracts.models;

public interface IBrandModel extends IBaseModel {
    int getId();

    String getBrandName();

    void setBrandName(String brandName) ;
}
