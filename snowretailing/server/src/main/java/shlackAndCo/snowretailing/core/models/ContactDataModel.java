package shlackAndCo.snowretailing.core.models;

import org.hibernate.validator.constraints.NotEmpty;
import shlackAndCo.snowretailing.core.contracts.models.IContactDataModel;
import shlackAndCo.snowretailing.dal.contracts.entities.IContactDataEntity;

import javax.validation.constraints.Size;

/**
 * Created by Владелец on 03/03/2017.
 */
public class ContactDataModel implements IContactDataModel {
    private int id;
    @NotEmpty
    @Size(min=7,max=13)
    private String phoneNumber;

    public ContactDataModel() {id = 0;}

    public ContactDataModel(IContactDataEntity entity) {
        this.id = entity.getId();
        this.phoneNumber = entity.getPhoneNumber();
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
    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
