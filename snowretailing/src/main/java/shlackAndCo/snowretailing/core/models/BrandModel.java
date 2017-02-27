package shlackAndCo.snowretailing.core.models;


import org.hibernate.validator.constraints.NotEmpty;
import shlackAndCo.snowretailing.core.contracts.models.IBrandModel;
import shlackAndCo.snowretailing.dal.contracts.entities.IBrandEntity;

import javax.validation.constraints.Size;

public class BrandModel implements IBrandModel{
    private int id;

    @NotEmpty
    @Size(max = 30)
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
}
