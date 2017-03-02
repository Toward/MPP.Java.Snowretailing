package shlackAndCo.snowretailing.core.contracts.models;

import shlackAndCo.snowretailing.dal.entities.ContactDataEntity;
import shlackAndCo.snowretailing.dal.entities.RentEntity;
import shlackAndCo.snowretailing.dal.entities.UserEntity;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Collection;


public interface ICredentialModel extends IBaseModel {
    public String getName();

    public void setName(String name);

    public String getSurname();

    public void setSurname(String surname);

    public String getPatronymyc();

    public void setPatronymyc(String patronymyc);

    public int getNumber();

    public void setNumber(int number);

    public String getSeries();

    public void setSeries(String series);

    public String getAgency();

    public void setAgency(String agency);

    public Timestamp getDate();

    public void setDate(Timestamp date);

    public Date getBirthday();

    public void setBirthday(Date birthday);

    public String getIdentifier();

    public void setIdentifier(String identifier);

    public String getType();

    public void setType(String type);
}
