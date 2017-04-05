package shlackAndCo.snowretailing.core.models;

import org.hibernate.validator.constraints.NotEmpty;
import shlackAndCo.snowretailing.core.contracts.models.ICredentialModel;
import shlackAndCo.snowretailing.dal.contracts.entities.ICredentialEntity;
import shlackAndCo.snowretailing.dal.entities.ContactDataEntity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;

public class CredentialModel implements ICredentialModel {
    private int id;
    @NotEmpty
    private String name;
    @NotEmpty
    private String surname;
    @NotEmpty
    private String patronymyc;
    @NotNull
    private int number;
    @NotEmpty
    private String series;
    @NotEmpty
    private String agency;
    //@DateTimeFormat(pattern="MM/dd/yyyy")
    @NotNull @Past
    private Timestamp date;
    //@DateTimeFormat(pattern="MM/dd/yyyy HH:mm:ss")
    @NotNull @Past
    private Date birthday;
    @NotEmpty
    private String identifier;
    @NotEmpty
    private String type;
    private Integer userId;
    Collection<String> phoneNumbers;

    public CredentialModel(){}

    public CredentialModel(ICredentialEntity entity){
        this.setId(entity.getId());
        this.name = entity.getName();
        this.surname = entity.getSurname();
        this.patronymyc = entity.getPatronymyc();
        this.number = entity.getNumber();
        this.series = entity.getSeries();
        this.agency = entity.getAgency();
        this.date = entity.getDate();
        this.birthday = entity.getBirthday();
        this.identifier = entity.getIdentifier();
        this.userId = entity.getUserByUserId() == null
                ? null
                : entity.getUserByUserId().getId();
        this.phoneNumbers = new ArrayList<>();
        for(ContactDataEntity phoneNumber : entity.getContactDatasById()){
            phoneNumbers.add(phoneNumber.getPhoneNumber());
        }
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
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getSurname() {
        return surname;
    }

    @Override
    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String getPatronymyc() {
        return patronymyc;
    }

    @Override
    public void setPatronymyc(String patronymyc) {
        this.patronymyc = patronymyc;
    }

    @Override
    public int getNumber() {
        return number;
    }

    @Override
    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String getSeries() {
        return series;
    }

    @Override
    public void setSeries(String series) {
        this.series = series;
    }

    @Override
    public String getAgency() {
        return agency;
    }

    @Override
    public void setAgency(String agency) {
        this.agency = agency;
    }

    @Override
    public Timestamp getDate() {
        return date;
    }

    @Override
    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Override
    public Date getBirthday() {
        return birthday;
    }

    @Override
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String getIdentifier() {
        return identifier;
    }

    @Override
    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public void setType(String type) {
        this.type = type;
    }

    @Override
    public Integer getUserId() {
        return userId;
    }

    @Override
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public Collection<String> getPhoneNumbers() {
        return phoneNumbers;
    }

    @Override
    public void setPhoneNumbers(Collection<String> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }
}
