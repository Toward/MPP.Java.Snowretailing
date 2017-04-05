package shlackAndCo.snowretailing.core.contracts.models;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Collection;


public interface ICredentialModel extends IBaseModel {
    String getName();
    void setName(String name);

    String getSurname();
    void setSurname(String surname);

    String getPatronymyc();
    void setPatronymyc(String patronymyc);

    int getNumber();
    void setNumber(int number);

    String getSeries();
    void setSeries(String series);

    String getAgency();
    void setAgency(String agency);

    Timestamp getDate();
    void setDate(Timestamp date);

    Date getBirthday();
    void setBirthday(Date birthday);

    String getIdentifier();
    void setIdentifier(String identifier);

    String getType();
    void setType(String type);

    Integer getUserId();
    void setUserId(Integer userId);

    Collection<String> getPhoneNumbers();
    void setPhoneNumbers(Collection<String> phoneNumbers);
}
