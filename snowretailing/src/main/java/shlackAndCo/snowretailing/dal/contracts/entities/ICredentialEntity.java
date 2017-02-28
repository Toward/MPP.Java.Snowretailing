package shlackAndCo.snowretailing.dal.contracts.entities;

import shlackAndCo.snowretailing.dal.entities.ContactDataEntity;
import shlackAndCo.snowretailing.dal.entities.RentEntity;
import shlackAndCo.snowretailing.dal.entities.UserEntity;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Collection;


public interface ICredentialEntity {
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

    public int getId();

    public void setId(int id);

    public Date getBirthday();

    public void setBirthday(Date birthday);

    public String getIdentifier();

    public void setIdentifier(String identifier);

    public String getType();

    public void setType(String type);

    public Collection<ContactDataEntity> getContactDatasById();

    public void setContactDatasById(Collection<ContactDataEntity> contactDatasById);

    public UserEntity getUserByUserId();

    public void setUserByUserId(UserEntity userByUserId);

    public Collection<RentEntity> getRentsById();

    public void setRentsById(Collection<RentEntity> rentsById);
}
