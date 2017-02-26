package shlackAndCo.snowretailing.core.models;

import shlackAndCo.snowretailing.dal.contracts.entities.IBrandEntity;
import shlackAndCo.snowretailing.core.contracts.models.IBrandModel;

public class BrandModel implements IBrandModel{
    private int id;
    private String brandName;

    public BrandModel(){
        id = 0;
    }

    public BrandModel(IBrandEntity brandEntity){
        id = brandEntity.getId();
        brandName = brandEntity.getBrandName();
    }

    public int getId() {
        return id;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public Boolean isValid() {
        return true;
    }
}
